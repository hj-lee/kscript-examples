import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

val isWindows = System.getProperty("os.name").contains("Windows")

fun String.createBaseProcessBuilder(workingDir: File?): ProcessBuilder {
    fun prepareWindowsCmd(cmd: String): String {
        val newCmd = cmd.replace("\\\\", "\\\\\\\\")
                .replace("\"", "\\\"")
        // println("old: $cmd")
        // println("new: $newCmd")
        return newCmd
    }
    val preamble = if (isWindows) arrayOf("cmd", "/c", "bash", "-c") else arrayOf("bash", "-c")
    val pb = ProcessBuilder(*preamble, if (isWindows) prepareWindowsCmd(this) else this)
    workingDir?.let { pb.directory(workingDir) } 
    return pb
}


fun String.runBash(workingDir: File? = null) {
    val pb = createBaseProcessBuilder(workingDir)
    pb.inheritIO().start().waitFor()
}

fun String.startBashPipe(workingDir: File? = null): Process? {
    return try {
        val pb = createBaseProcessBuilder(workingDir)
        pb.redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE).start()
    } catch(e: IOException) {
        e.printStackTrace()
        null
    }
}

fun String.evalBash(workingDir: File? = null) : String? {
    val proc = startBashPipe(workingDir)
    proc?.waitFor()
    return proc?.inputStream?.bufferedReader()?.readText()
}

