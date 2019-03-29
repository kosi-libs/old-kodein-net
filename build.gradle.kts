import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("org.jetbrains.kotlin.platform.js")
    id("org.jetbrains.kotlin.frontend") version "0.0.45"
    id("kotlin-dce-js")
}

repositories {
    maven( url = "https://kotlin.bintray.com/kotlin-js-wrappers")
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")

    val wrapperVersion = "pre.70-kotlin-1.3.21"
    compile("org.jetbrains:kotlin-react-dom:16.6.0-$wrapperVersion")
    compile("org.jetbrains:kotlin-react-router-dom:4.3.1-$wrapperVersion")
    compile("org.jetbrains:kotlin-styled:1.0.0-$wrapperVersion")
}

tasks.getByName<Kotlin2JsCompile>("compileKotlin2Js") {
    kotlinOptions {
        moduleKind = "commonjs"
        sourceMap = true
        metaInfo = true
    }
}

kotlinFrontend {
    bundlesDirectory = "$buildDir/web/bundle"
    
    npm {
        dependency("react", "^16.6.0")
        dependency("react-dom", "^16.6.0")
        dependency("react-router", "^4.3.1")
        dependency("react-router-dom", "^4.3.1")

        dependency("css-in-js-utils", "^2.0.1")
        dependency("inline-style-prefixer", "^5.0.1")
        dependency("styled-components", "^3.4.6")

        dependency("core-js", "^3.0.0")
    }

    bundle<WebPackExtension>("webpack") {
        this as WebPackExtension
        bundleName = "kodein-net"
        sourceMapEnabled = true
    }
}

val copyResources = task<Sync>("copyResources") {
    group = "build"
    from("src/main/resources")
    into("$buildDir/web")
    preserve {
        include("bundle/**")
    }
}

tasks.getByName("build") {
    dependsOn(copyResources)
    dependsOn("bundle")
}
