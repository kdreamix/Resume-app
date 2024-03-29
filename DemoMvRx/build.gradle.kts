// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion = "1.3.31"
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.1")
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0-alpha04")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

