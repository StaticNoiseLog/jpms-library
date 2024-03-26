plugins {
    id("jpms-library.shared-conventions") // convention plugin from buildSrc

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

dependencies {
    testImplementation(libs.kotlin.test.junit5) // JUnit 5 integration for Kotlin
    testRuntimeOnly(libs.junit.jupiter.engine) // JUnit 5 engine for running tests
    testRuntimeOnly(libs.junit.platform.launcher) // JUnit 5 support for IDEs and build tools
}

// Workaround required so that the Kotlin classes are found by the Java compiler. Note that the module name
// "jpms.library.deeplearning" must be the same as the module name in the module-info.java file.
tasks.compileJava {
    options.compilerArgumentProviders.add(object : CommandLineArgumentProvider {
        @CompileClasspath
        val kotlinClasses = kotlin.sourceSets.main.flatMap { it.kotlin.classesDirectory }

        override fun asArguments() = listOf(
            "--patch-module",
            "jpms.library.deeplearning=${kotlinClasses.get().asFile.absolutePath}"
        )
    })
}