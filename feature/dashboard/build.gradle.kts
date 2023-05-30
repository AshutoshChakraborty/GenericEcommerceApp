plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.dashboard"
    compileSdk =33
}

dependencies {
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
    implementation (Dependencies.hiltNavigationCompose)
}