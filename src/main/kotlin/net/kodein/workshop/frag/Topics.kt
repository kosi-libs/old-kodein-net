package net.kodein.workshop.frag

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.li
import styled.css
import styled.styledH2
import styled.styledUl

class Topics : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        styledH2 {
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +"Topics"
        }

        styledUl {
            css {
                paddingTop = 28.px
                listStyleType = ListStyleType.circle
                maxWidth = 720.px
                margin(LinearDimension.auto)
                padding(horizontal = 50.px)
                textAlign = TextAlign.left

                "li" {
                    marginTop = 0.2.em
                }
            }

            li { +"Introduction to Kotlin/Multiplatform" }
            li { +"Kotlin/Multiplatform Gradle plugin." }
            li { +"Kotlin syntax for multiplatform: expect and actual." }
            li { +"Testing each platform." }
            li { +"Using the library on Android." }
            li { +"Using the library on iOS." }
            li { +"Using the library on the Web." }
            li { +"Using MVP or MVVM to abstract behaviour." }
            li { +"Multi-platform low-level: KotlinX (Serialization, IO, Coroutines, AtomicFu)." }
            li { +"Multi-platform network: Ktor-Clients (HTTP request, REST client)." }
            li { +"Multi-platform high-level: Kodein (DI, DB, MVP, Log) and Korlibs (IO, Files, Templates, Images, Crypto)." }
        }
    }
}