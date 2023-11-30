Modular Kotlin/Java Library Gradle Project
==========================================

How to set up a Gradle project that uses JPMS modules and that can be used for mixed Kotlin/Java coding.

**JPMS = Java Platform Module System** (introduced with Java 9, aka "Project Jigsaw")

Gradle (Step 1)
---------------

```
mkdir jpms-library
cd jpms-library/
```

Set JAVA_HOME to the desired JDK.

Generate multi-project build with `./gradlew init`:

- type of project: library
- implementation language: Kotlin
- build script DSL: Kotlin
- project name: jpms-library
- source package: com.staticnoiselog

This way of project initialization should already use "toolchain" in the build
script.

    ./gradlew clean build

IntelliJ (Step 2)
-----------------

Open project in IntelliJ.
Check/fix the project SDK version.

### First Module

First we convert the existing "lib" into a JPMS module.

In IntelliJ, right-click on `src/main`, New, Directory
-> IntelliJ offers "Gradle Source Sets java". Select this.

Right-click on the newly created `java` subdirectory, New, `module-info.java`

Choose a good name for the first module as this how your library will be seen by
users. The "kotlin.stdlib" module is required.

    module jpms.library.lib {
        requires kotlin.stdlib;
    }

### Add Second Module

To add a second module we have to add a Gradle subproject and convert that into
a JPMS module, too.

**In IntelliJ:**

- Right-click on the project's root directory: New, Module...
- Prefer underscores for the name of modules: long_module_name
  (dashes are technically OK, but snake_case is preferable for subdirectories)
- Language: Java (because "Kotlin" is not an available choice)
- Build System: Gradle
- JDK: the actual JDK you are using for your project
- Gradle DSL: Kotlin
- Under "Advanced Settings" you can change "GroupId" to set a package name.
- Ignore a possible warning "Unsupported Project JDK" and proceed.

Note how an additional `include` was added to `settings.gradle.kts` for the new
module.

The new module has a `build.gradle.kts` file designed for Java. Replace its
content with the one from the first module (designed for Kotlin).

The directory structure for Java has been created. But you need to add it for
Kotlin.
Create the directory `src/main/kotlin` and then "Reload All Gradle Projects" in
IntelliJ (this makes IntelliJ discover the new directory as Gradle Source Set).

Now that IntelliJ has realized that the new module is about Kotlin, too, adding
`src/test/kotlin` is supported:  
right-click on `src/test`, New, Directory -> IntelliJ offers "Gradle Source Sets kotlin"

Convert the new Gradle subproject into a JPMS module:  
Right-click on the `java` subdirectory, New, `module-info.java`

    module jpms.library.deeplearning {
        requires kotlin.stdlib;
    }

**Manually:**

- create directory for new module
- create directory structure with src/main/kotlin and src/main/java
- add new module to `settings.gradle.kts` (`include("deeplearning")`)
- copy over `build.gradle.kts` from an existing module

### Renaming a Module

Status IntelliJ 2023.2.5:

- Right-click the module in IntelliJ, Refactor, Rename..., Rename module
- Ignore errors
- Manually rename the Gradle subproject in `settings.gradle.kts`
- "Reload All Gradle Projects" with the button in the Gradle window

### Deleting a Module

Status IntelliJ 2023.2.5:

- Navigate to IntelliJ's Project Structure (Ctrl+Alt+Shift+S)
- Delete the module (in Project Settings, Modules)
- Manually delete the directory
- Manually remove the subproject from `settings.gradle.kts`
- "Reload All Gradle Projects" with the button in the Gradle window
