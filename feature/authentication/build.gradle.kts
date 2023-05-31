plugins {
    id("com.android.library")
    id ("kotlin-kapt")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.authentication"
    compileSdk =33
    defaultConfig {
        minSdk =21
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
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
    //Test dependency
    testImplementation (Dependencies.jUnit)
    androidTestImplementation (Dependencies.jUnitExt)
    androidTestImplementation (Dependencies.espresso)

    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
    implementation(composeBom)
    androidTestImplementation (composeBom)

    // UI Tests
    androidTestImplementation (Dependencies.composeUiTest)
    // Android Studio Preview support
    implementation (Dependencies.composePreviews)
    debugImplementation (Dependencies.composeTooling)
    // Foundation (Dependencies.Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation (Dependencies.composeFoundation)
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation (Dependencies.composeUi)
    // Material Design
    implementation (Dependencies.composeMaterial)
    // Optional - Integration with ViewModels
    implementation (Dependencies.composeViewmodel)
    // Animations
    implementation (Dependencies.composeAnimation)

    implementation (Dependencies.hilt)
    kapt (Dependencies.hiltCompiler)
    implementation (Dependencies.hiltNavigationCompose)
    implementation (Dependencies.hiltWorkManager)
}