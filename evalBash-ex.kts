
@file:Include("evalBash.kt")

try {
    println("runBash")
    "ls -ld . ".runBash()
    "kscript println\\(1\\)".runBash()
    "printf 'single quote'".runBash()
    "printf \"double quote\"".runBash()
    "printf \"back n \\n after newline\"".runBash()
    "kscript 'println(\"a\\nb c d\\nlast line \")'".runBash()
} catch (e: Exception) {
    e.printStackTrace()
}

try {
    println("evalBash")
    println("ls -ld .".evalBash())
    println("kscript println\\(1\\)".evalBash())
    println("printf 'single quote'".evalBash())
    println("printf \"double quote\"".evalBash())
    println("printf \"back n \\n after newline\"".evalBash())
    println("kscript 'println(\"a\\nb c d\\nlast line \")'".evalBash())
} catch (e: Exception) {
    e.printStackTrace()
}

