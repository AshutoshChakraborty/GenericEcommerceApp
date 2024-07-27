package Utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.7"
        }
        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation",libs.findLibrary("compose-ui").get())
            add("implementation",libs.findLibrary("compose-ui-tooling-preview").get())
            add("implementation",libs.findLibrary("compose-ui-graphics").get())
            add("implementation",libs.findLibrary("compose-material3").get())
            add("implementation",libs.findLibrary("lifecycle-viewmodel-compose").get())
            add("implementation",libs.findLibrary("androidx-compose-animation").get())
            add("debugImplementation",libs.findLibrary("compose-ui-tooling").get())
            add("androidTestImplementation",libs.findLibrary("composeUiTest").get())
            add("debugImplementation",libs.findLibrary("composeUiTestManifest").get())
        }
    }

}