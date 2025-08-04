plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin") // Hilt Plugin
}

kotlin {
    jvmToolchain(17) // Ensure Kotlin compiles with JVM 17
}

kapt {
    correctErrorTypes = true
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

android {
    compileSdk = 34
    defaultConfig {
        namespace = "com.test.mytest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += listOf("-Xuse-ir")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2024.02.02"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose")
    implementation("androidx.lifecycle:lifecycle-runtime-compose")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("androidx.compose.compiler:compiler:1.5.11")


    // Add this for Compose Tooling
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    // Hilt & ViewModel Integration
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coil for Image Loading
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Retrofit & Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
}
