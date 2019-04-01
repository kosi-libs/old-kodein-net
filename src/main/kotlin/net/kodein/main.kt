package net.kodein

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import react.dom.render
import styled.StyledComponents
import styled.injectGlobal
import kotlin.browser.document

val Color.Companion.kodeinOrange get() = Color("#E8441F")
val Color.Companion.kodeinGreen get() = Color("#46AF6D")
val Color.Companion.kotlinConfOrange get() = Color("#f94105")

fun main() {

    render(document.getElementById("app")) {
        StyledComponents.injectGlobal {
            universal {
                margin(0.px)
                padding(0.px)
            }

            body {
                backgroundColor = Color("#eee")
                fontFamily = "Picon, sans-serif"
                fontSize = 1.25.em
                media("(max-width: 880px)") {
                    fontSize = 1.1.em
                }
            }

            "#app" {
                backgroundColor = Color.white
                maxWidth = 1040.px
                margin(LinearDimension.auto)
                textAlign = TextAlign.center
                boxShadow(Color.gray, blurRadius = 2.px)
            }
        }

        child(App::class) {}
    }
}
