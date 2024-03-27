package com.staticnoiselog.ai

/*
IntelliJ bad:
C:\Users\beat\.gradle\jdks\eclipse_adoptium-21-amd64-windows\jdk-21.0.2+13\bin\java.exe -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -p C:\BK\IT\DEV\JAVA\IntelliJ\jpms-library\deeplearning\build\classes\java\main;C:\Users\beat\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib\1.9.23\dbaadea1f5e68f790d242a91a38355a83ec38747\kotlin-stdlib-1.9.23.jar -m jpms.library.deeplearning/com.staticnoiselog.ai.MainKot


You can run this:
C:\Users\beat\.gradle\jdks\eclipse_adoptium-21-amd64-windows\jdk-21.0.2+13\bin\java.exe -p C:\BK\IT\DEV\JAVA\IntelliJ\jpms-library\deeplearning\build\libs\deeplearning.jar;C:\Users\beat\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib\1.9.23\dbaadea1f5e68f790d242a91a38355a83ec38747\kotlin-stdlib-1.9.23.jar -m jpms.library.deeplearning/com.staticnoiselog.ai.MainKot

 */
object MainKot {
    @JvmStatic
    fun main(args: Array<String>) {
        println("I am a workaround for 'package is empty or does not exist' build errors.")

        // we can call Kotlin code from Java, but requires the "--patch-module" workaround in build.gradle.kts
        KotlinForJava("Java Duke").helloFromKotlin()
    }
}