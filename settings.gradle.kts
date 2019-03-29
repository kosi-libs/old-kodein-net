rootProject.name = "Kodein.net"

val kotlinVersion = "1.3.21"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            val id = requested.id.id
            when {
                id.startsWith("org.jetbrains.kotlin.platform.") || id.startsWith("kotlin-") -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
                id.startsWith("com.github.salomonbrys.gradle.kotlin.js.") -> useModule("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:${requested.version}")
                id == "org.jetbrains.kotlin.frontend" -> useModule("org.jetbrains.kotlin:kotlin-frontend-plugin:${requested.version}")
//                id == "org.jetbrains.kotlin.frontend" -> useModule("org.jetbrains.kotlin:kotlin-frontend-plugin:${requested.version}")
//                id == "com.github.salomonbrys.gradle.sass" -> useModule("com.github.salomonbrys.gradle.sass:Gradle-Sass:${requested.version}")
            }
        }
    }

    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
        jcenter()
    }
}
