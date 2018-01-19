#!/usr/bin/env kscript

@file:KotlinOpts("-J-Xmx256m")
//KOTLIN_OPTS -J-Xms256m

println (Runtime.getRuntime().maxMemory())	
