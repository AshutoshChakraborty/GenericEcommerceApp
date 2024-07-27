plugins {
    id ("kotlin-kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose =true
    }
    composeOptions {
        kotlinCompilerExtensionVersion ="1.4.7"
    }
}

dependencies {

    implementation (libs.androidx.appCompat)
    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
    implementation(composeBom)
    androidTestImplementation (composeBom)
    implementation (libs.androidx.coreKtx)
    implementation (libs.constraintlayout)

    // Android Studio Preview support
    implementation (libs.compose.ui.tooling.preview)
    debugImplementation (libs.compose.ui.tooling)
    // Foundation (Dependencies.Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation (libs.compose.foundation)
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation (libs.compose.ui)
    // Material Design
    implementation (libs.compose.material3)

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (Dependencies.e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation (libs.compose.material.icon.core)
    // Optional - Add full set of material icons
    implementation (libs.compose.material.icon.extended)
    // Optional - Add window size utils
    implementation (libs.androidx.compose.material3.windowSizeClass)
    // Optional - Integration with activities
    implementation (libs.activity.compose)
    // Optional - Integration with ViewModels
    implementation (libs.lifecycle.viewmodel.compose)
    // Animations
    implementation (libs.androidx.compose.animation)


    //Accompanist
    implementation (libs.accompanist.systemuicontroller)
    implementation (libs.accompanist.pager)
    // If using indicators, also depend on
    implementation (libs.accompanist.pager.indicator)
    implementation (libs.accompanist.permissions)
    implementation (libs.accompanist.placeholder)
    implementation (libs.accompanist.navigation.animation)
    implementation (libs.accompanist.navigation.material)
    implementation (libs.accompanist.drawablepainter)
    implementation (libs.accompanist.swiperefresh)

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