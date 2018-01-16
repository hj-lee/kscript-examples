
@file:Include("evalBash.kt")

fun runBashes(vararg cmds: String) {
    cmds.forEach {
        println("run:$it")
        it.runBash()
        println()
    }
}

fun evalBashes(vararg cmds: String) {
    cmds.forEach {
        println("eval:$it")
        println(it.evalBash())
    }
}

val cmds_old = arrayOf("ls -ld .",
        "echo 'a\\ \\\" ' \\'  \'",
        "ls ./../",
        "ls /home/",
        "echo C:\\\\. ",
        "kscript println\\(1\\)",
        "printf 'single quote'",
        "printf \"double quote\"",
        "printf \"back n \\n after newline\"",
        "kscript 'println(\"a\\nb c d\\nlast line \")'"
)

val cmds = arrayOf("ls -ld .",
        // "echo \"a\\ \\\" ' \\'  \"",
        // "echo 'b c / \" \\\\ \\\" '",
        // "echo /a/b/c/d/e/f/",
        "echo C:\\\\. ",
        "echo 'C:\\\\\\\\.' ",
        "kscript println\\(1\\)",
        // "echo 'single quote'",
        // "echo \"double quote\"",
        // "echo \"back n \\n after newline\"",
        "kscript 'println(\"a\\nb c d\\nlast line \")'"
)

try {
    println("runBash")
    runBashes(*cmds)
} catch (e: Exception) {
    e.printStackTrace()
}

try {
    println("evalBash")
    evalBashes(*cmds)
} catch (e: Exception) {
    e.printStackTrace()
}

