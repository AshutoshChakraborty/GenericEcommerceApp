plugins {
    id ("kotlin-kapt")
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
}

android {
    compileSdk =33

    defaultConfig {
        applicationId ="com.example.myapplication"
        minSdk =21
        targetSdk =33
        versionCode =1
        versionName ="1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose =true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled  =false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility =JavaVersion.VERSION_1_8
        targetCompatibility =JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion ="1.4.7"
    }
    kapt {
        correctErrorTypes =true
    }
    namespace ="com.example.myapplication"
}

dependencies {
    implementation (project(":feature:authentication"))
    implementation (project(":feature:dashboard"))
    implementation (Dependencies.appCompat)
    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
    implementation(composeBom)
    androidTestImplementation (composeBom)
    implementation (Dependencies.coreKtx)
    implementation (Dependencies.constraintLayout)

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

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (Dependencies.e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation (Dependencies.composeMaterialIconCore)
    // Optional - Add full set of material icons
    implementation (Dependencies.composeMaterialIconExtended)
    // Optional - Add window size utils
    implementation (Dependencies.composeWindowSize)
    // Optional - Integration with activities
    implementation (Dependencies.composeActivity)
    // Optional - Integration with ViewModels
    implementation (Dependencies.composeViewmodel)
    // Animations
    implementation (Dependencies.composeAnimation)


    //Accompanist
    implementation (Dependencies.accompanistSystemUiController)
    implementation (Dependencies.accompanistPager)
    // If using indicators, also depend on
    implementation (Dependencies.accompanistPagerIndicator)
    implementation (Dependencies.accompanistPermission)
    implementation (Dependencies.accompanistPlaceholder)
    implementation (Dependencies.accompanistNavigationAnimation)
    implementation (Dependencies.accompanistNavigationMaterial)
    implementation (Dependencies.accompanistDrawablePainer)
    implementation (Dependencies.accompanistSwipeRefresh)

    //Hilt
    implementation (Dependencies.hilt)
    kapt (Dependencies.hiltCompiler)
    implementation (Dependencies.hiltNavigationCompose)
    implementation (Dependencies.hiltWorkManager)

    implementation (Dependencies.workRuntime)

    // When using Kotlin.
    kapt (Dependencies.hiltAndroidXCompiler)
    implementation (Dependencies.hiltNavigationFragment)

    //Test dependency
    testImplementation (Dependencies.jUnit)
    androidTestImplementation (Dependencies.jUnitExt)
    androidTestImplementation (Dependencies.espresso)
    // UI Tests
    androidTestImplementation (Dependencies.composeUiTest)
    debugImplementation (Dependencies.composeUiTestManifest)

    // For instrumented tests.
    androidTestImplementation (Dependencies.daggerHiltTesting)
    // ...with Kotlin.
    kaptAndroidTest (Dependencies.hiltCompiler)
    //Retrofit
    implementation (Dependencies.retrofit)
    implementation (Dependencies.gsonConverter)
    implementation (Dependencies.loggingInterceptor)
}