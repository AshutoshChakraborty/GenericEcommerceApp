import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AccompanistConventionPlugin:Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation",libs.findLibrary("accompanist-systemuicontroller").get())
                add("implementation",libs.findLibrary("accompanist-pager").get())
                add("implementation",libs.findLibrary("accompanist-pager-indicator").get())
                add("implementation",libs.findLibrary("accompanist-permissions").get())
                add("implementation",libs.findLibrary("accompanist-placeholder").get())
                add("implementation",libs.findLibrary("accompanist-navigation-animation").get())
                add("implementation",libs.findLibrary("accompanist-navigation-material").get())
                add("implementation",libs.findLibrary("accompanist-drawablepainter").get())
                add("implementation",libs.findLibrary("accompanist-swiperefresh").get())

            }
        }

    }
}