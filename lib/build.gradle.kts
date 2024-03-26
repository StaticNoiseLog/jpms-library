plugins {
    id("jpms-library.shared-conventions") // convention plugin from buildSrc

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

dependencies {
    // to use the other module you have to add a dependency to its Gradle subproject
    implementation(project(":deeplearning"))

    dependencies {
        testImplementation(libs.kotlin.test.junit5) // JUnit 5 integration for Kotlin
        testRuntimeOnly(libs.junit.jupiter.engine) // JUnit 5 engine for running tests
        testRuntimeOnly(libs.junit.platform.launcher) // JUnit 5 support for IDEs and build tools
    }

    // Below are example dependencies added by "gradle init". Compare with the new
    // "./gradle/libs.versions.toml" that is generated since Gradle 8.5.

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    // api(libs.commons.math3)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    // implementation(libs.guava)
}

// Workaround required so that Kotlin code can be used in Java files. Note that the module name
// for the --patch-module argument must be the same as the module name in the module-info.java file.
tasks.compileJava {
    options.compilerArgumentProviders.add(object : CommandLineArgumentProvider {
        @CompileClasspath
        val kotlinClasses = kotlin.sourceSets.main.flatMap { it.kotlin.classesDirectory }

        override fun asArguments() = listOf(
            "--patch-module",
            "jpms.library.lib=${kotlinClasses.get().asFile.absolutePath}" // module name must match module-info.java
        )
    })
}