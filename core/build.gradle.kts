plugins {
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

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
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
    implementation (Dependencies.composeAnimation)
}