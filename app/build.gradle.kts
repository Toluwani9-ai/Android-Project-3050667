plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
    id("com.google.devtools.ksp") version "2.0.0-1.0.23"   // FIXED
}

android {
    namespace = "com.toluwani.tolutraveljournalmilestone2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.toluwani.tolutraveljournalmilestone2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    // COMPOSE
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.3")

    // ACTIVITY WITH COMPOSE
    implementation("androidx.activity:activity-compose:1.9.0")

    // NAVIGATION
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // ROOM DATABASE
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // ROOM COMPILER (KSP)
    ksp("androidx.room:room-compiler:2.6.1")

    // LIFECYCLE / VIEWMODEL
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")

    // COROUTINES
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
}