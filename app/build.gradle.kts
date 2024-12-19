plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    //id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    //id("com.google.devtools.ksp")
    //id("com.google.devtools.ksp") version "1.9.0"
}

android {
    namespace = "com.example.dz15room"
    compileSdk = 35

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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //ksp("androidx.room:room-compiler:2.5.0")
    kapt(libs.androidx.room.compiler)

    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    //ksp("androidx.room:room-compiler:2.5.0")
    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:$room_version")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")




    //Компоненты Room
    //implementation(libs.androidx.room.runtime)

    // optional - Kotlin Extensions and Coroutines support for Room
    //implementation(libs.androidx.room.ktx)

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
    //api("org.jetbrains.kotlin:kotlin-coroutines-core:1.7.3")
    //api("org.jetbrains.kotlin:kotlin-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    //implementation (libs.kotlin.stdlib)
    //implementation (libs.kotlinx.coroutines.core)
    //implementation (libs.kotlinx.coroutines.android)




}