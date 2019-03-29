package net.kodein.mainpage.fragment

import kotlinx.css.*
import net.kodein.mainpage.MainPage
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.b
import react.dom.br
import styled.*

class Introduction : RComponent<MainPage.FragmentProps, RState>() {

    private fun r(block: RBuilder.() -> Unit) = block

    override fun RBuilder.render() {
        styledH1 {
            css {
                fontWeight = FontWeight.w700
                fontSize = 1.9.em
                margin(40.px)
            }

            +"We are Kotlin experts."
        }

        styledUl {
            css {
                listStyleType = ListStyleType.none
                display = Display.flex
                flexWrap = FlexWrap.wrap
                justifyContent = JustifyContent.spaceAround
                maxWidth = 700.px
                margin(LinearDimension.auto)
            }

            listOf(
                    "training" to r { +"Training & consulting services." },
                    "kotlin" to r { +"Jetbrains certified professional training." },
                    "layers" to r { b { +"Kotlin" } ; +"/Everywhere:" ; br {} ; +"all mobile platforms." },
                    "opensource" to r { +"Open Source multi-platform framework." }
            ).forEach { (img, content) ->
                styledLi {
                    css {
                        width = 150.px
                        margin(vertical = 20.px)
                        fontSize = 0.75.em
                    }

                    styledImg(src = "imgs/$img.svg") {
                        css {
                            width = 60.px
                            height = 55.px
                            marginBottom = 40.px
                        }
                    }
                    styledP {
                        content()
                    }
                }
            }
        }
    }

}