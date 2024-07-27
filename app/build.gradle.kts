plugins {
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id("myapplication.android.application")
    id("myapplication.android.application.compose")
    id("myapplication.android.accompanist")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myapplication"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kapt {
        correctErrorTypes = true
    }
    namespace = "com.example.myapplication"
}

dependencies {
    implementation(project(":feature:authentication"))
    implementation(project(":feature:dashboard"))
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.coreKtx)
    implementation(libs.constraintlayout)

    // Optional - Integration with activities
    implementation(libs.activity.compose)


    //Hilt
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.hiltWorkManager)

    implementation(libs.workRuntime)

    // When using Kotlin.
    kapt(libs.hiltAndroidXCompiler)
    implementation(libs.hiltNavigationFragment)

    //Test dependency
    testImplementation(libs.jUnit)
    androidTestImplementation(libs.jUnitExt)
    androidTestImplementation(libs.espresso)


    // For instrumented tests.
    androidTestImplementation(libs.daggerHiltTesting)
    // ...with Kotlin.
    kaptAndroidTest(libs.hiltCompiler)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.gsonConverter)
    implementation(libs.loggingInterceptor)
}