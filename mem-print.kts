#!/usr/bin/env kscript

@file:Include("evalBash.kt")


fun printMem(maxmem: Int, initial: Int) {
	val cmd = "kscript - <<\"EOF\"\n" +
	"@file:KotlinOpts(\"-J-Xmx${maxmem}m\") \n" +
	"//KOTLIN_OPTS -J-Xms${initial}m \n" +
	"println(Runtime.getRuntime().maxMemory()) \n" +
	"EOF\n"
	println("-J-Xmx${maxmem}m -J-Xms${initial}m : ${cmd.evalBash()}")
}

printMem(256,1)
printMem(256,100)
printMem(256,255)
printMem(256,256)
printMem(512,1)
printMem(512,100)
printMem(512,256)
printMem(512,511)
printMem(512,512)
