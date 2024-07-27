plugins {
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("myapplication.android.feature")
    id("myapplication.android.feature.compose")
    id("myapplication.android.accompanist")
}

android {
    namespace = "com.example.authentication"
    compileSdk =33
}

dependencies {
    implementation (project(":core"))
    implementation (libs.androidx.appCompat)
    implementation (libs.androidx.coreKtx)
    implementation (libs.constraintlayout)


    // Optional - Integration with activities
    implementation (libs.activity.compose)

    //Hilt
    implementation (libs.hilt)
    kapt (libs.hiltCompiler)
    implementation (libs.hiltNavigationCompose)
    implementation (libs.hiltWorkManager)

    implementation (libs.workRuntime)

    // When using Kotlin.
    kapt (libs.hiltAndroidXCompiler)
    implementation (libs.hiltNavigationFragment)

    //Test dependency
    testImplementation (libs.jUnit)
    androidTestImplementation (libs.jUnitExt)
    androidTestImplementation (libs.espresso)
    // UI Tests
    androidTestImplementation (libs.composeUiTest)
    debugImplementation (libs.composeUiTestManifest)

    // For instrumented tests.
    androidTestImplementation (libs.daggerHiltTesting)
    // ...with Kotlin.
    kaptAndroidTest (libs.hiltCompiler)
    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.gsonConverter)
    implementation (libs.loggingInterceptor)
}