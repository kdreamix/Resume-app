import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

androidExtensions {
    isExperimental =true
}
android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.mak.demomvrx"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    val nav_version =  "2.1.0-alpha04"
    val room_version = "2.1.0-alpha07"
    val koin_version = "2.0.0"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation ("com.google.android.material:material:1.1.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
    implementation("com.airbnb.android:mvrx:1.0.1")
    implementation("com.airbnb.android:epoxy:3.5.0")
    implementation("com.airbnb.android:paris:1.2.1")
    // If you're using Paris annotations.
    kapt ("com.airbnb.android:paris-processor:1.2.1")
    kapt ("com.airbnb.android:epoxy-processor:3.5.0")

    implementation("androidx.navigation:navigation-fragment:$nav_version") // For Kotlin use navigation-fragment-ktx
    implementation("androidx.navigation:navigation-ui:$nav_version") // For Kotlin use navigation-ui-ktx
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version") // For Kotlin use kapt instead of annotationProcessor
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:$room_version")
    implementation ("androidx.room:room-rxjava2:2.1.0-beta01")
    implementation ("androidx.palette:palette:1.0.0")
    implementation ("org.koin:koin-android:$koin_version")
    implementation ("com.github.bumptech.glide:glide:4.9.0")
    kapt("com.github.bumptech.glide:compiler:4.9.0")

}

repositories {
    mavenCentral()
    maven("http://repository.jetbrains.com/all")
}