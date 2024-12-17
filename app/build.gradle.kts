plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    //id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    //id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.dz15room"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dz15room"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.room.common)
    val room_version = "2.6.1"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Компоненты Room
    implementation(libs.androidx.room.runtime)

    //ksp("androidx.room:room-compiler:2.5.0")
    kapt("androidx.room:room-compiler:2.6.1")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
    //Компоненты жизненогоциклаandroidx.lifecycle:lifecycle
    implementation(libs.androidx.lifecycle.runtime.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common.java8)

    //Компонент Ресекл Виев
    implementation (libs.androidx.recyclerview)
    implementation (libs.androidx.recyclerview.selection)

    //Компоненты котлин и корутины
    implementation(libs.kotlin.stdlib.jdk7)
    api("org.jetbrains.kotlin:kotlin-coroutines-core:$rootProject.coroutines")
    api("org.jetbrains.kotlin:kotlin-coroutines-android:$rootProject.coroutines")




}