
@file:Include("evalBash.kt")

import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

println("recursive.kts start - ${args.asList()}")

if (args.size < 1) {
    "kscript recursive.kts 1".runBash()
} else {
    val i = args[0].toInt()
    if (i < 5) {
        "kscript recursive.kts ${i+1}".runBash()
    }
}

println("recursive.kts finished - ${args.asList()}")
