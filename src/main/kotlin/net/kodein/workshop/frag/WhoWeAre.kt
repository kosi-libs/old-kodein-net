package net.kodein.workshop.frag

import kotlinx.css.*
import net.kodein.Text
import net.kodein.kodeinOrange
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.b
import react.dom.br
import react.dom.p
import styled.*

class WhoWeAre : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        styledH2 {
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +"Who We Are"
        }

        styledDiv {
            css {
                maxWidth = 750.px
                margin(LinearDimension.auto)
                padding(horizontal = 50.px)
                textAlign = TextAlign.left

                kotlinx.css.p {
                    margin(vertical = 1.em)
                }
            }

            p {
                styledA (href = "#/") {
                    css {
                        color = Color.kodeinOrange
                    }
                    b { +"KODEIN" }
                    +"Koders"
                }
                +" is the first trainer in Europe to be certified by Jetbrains for Kotlin training."
            }

            p {
                +"We are at the root of the #1 multi-platform framework that allows a developer to create business code units that can run on Android, iOS, the Web, server and desktop softwares."
            }
        }
    }

}