#!/usr/bin/env kscript

@file:KotlinOpts("-J-Xmx256m")
//KOTLIN_OPTS -J-Xms256m

@file:DependsOn("com.github.holgerbrandl:kscript-support:1.2.4")

import kscript.text.*

println (Runtime.getRuntime().maxMemory())	

val lines = kscript.text.resolveArgFile(args)

lines.print()
