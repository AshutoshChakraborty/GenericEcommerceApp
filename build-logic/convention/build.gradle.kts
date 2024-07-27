import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    google()
}
group = "com.example.myapplication.buildLogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

}
gradlePlugin{
    plugins {
        register("androidApplication"){
            id = "myapplication.android.application"
            implementationClass= "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose"){
            id = "myapplication.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("accompanist"){
            id = "myapplication.android.accompanist"
            implementationClass = "AccompanistConventionPlugin"
        }
        register("feature"){
            id = "myapplication.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("featureCompose"){
            id = "myapplication.android.feature.compose"
            implementationClass = "AndroidFeatureComposeConventionPlugin"
        }
    }
}