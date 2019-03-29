package net.kodein.mainpage.fragment

import kotlinx.css.*
import kotlinx.css.properties.borderTop
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLElement
import react.*
import react.dom.b
import react.dom.br
import styled.*

class KotlinEverywhere : RComponent<MainPage.FragmentProps, RState>(), MainPage.AnchorFragment {

    override val scrollTo = createRef<HTMLElement>()

    private fun r(block: RBuilder.() -> Unit) = block

    override fun RBuilder.render() {
        styledH2 {
            ref = scrollTo
            css {
                fontSize = 1.9.em
                fontWeight = FontWeight.w700
                margin(top = 80.px, bottom = 40.px)
                color = Color.kodeinOrange
            }

            +"Kotlin"
            styledSpan {
                css {
                    fontWeight = FontWeight.w300
                }
                +"/Everywhere"
            }
        }

        styledDiv {
            css {
                backgroundColor = Color("#f2e2ed")
                padding(top = 40.px, bottom = 40.px)
            }

            styledH3 {
                css {
                    fontWeight = FontWeight.w300
                    fontSize = 1.35.em
                }

                +"We help you deploy your business everywhere:"
                br {}
                b {
                    +"All mobile & web platforms at once!"
                }
            }

            listOf(
                    r { +"Code once," ; br {} ; +"test once," ; br {} ; +"run everywhere." } to
                            r {
                                +"Kotlin is the first industry language to be developped with multiplatform in mind."
                                br {}
                                +"This means that, rather than trying to squeeze a language and an unfitted runtime into another target, the language and its runtime has been thought from its very inception for multiplatform and portability."
                                br {}
                                +"Doing so, the language elegantly factorizes the common runtime capabilities while allowing programmers to be specific about each targetted platform."
                            },
                    r { +"Kodein Koders is at the center of Kotlin/Everywhere in Europe." } to
                            r {
                                +"We released the first non-Jetbrains library to be multiplatform and usable on each and every platform Kotlin can target."
                                br {}
                                +"By partnering closely with JetBrains (the creators of Kotlin), we ensure that we are always on top of each evolution of the language."
                                br {}
                                +"Kodein Koders is the first training provider in Europe focused on Kotlin/Everywhere technologies, we provided industry recognized training on multiplatform, asychronous & native Kotlin development."
                            },
                    r { +"Open source is a way of code:" ; br {} ; +"using is only the first step." } to
                            r {
                                +"The Kodein Framework is the first Open-Source multiplatform mobile framework written exclusively for Kotlin/Everywhere. It allows programmers to focus on their application business."
                                br {}
                                +"We firmly believe that open sourcing non-business critical components and contributing to existing projects leads to better software."
                                br {}
                                +"Kodein Koders is heavily invested in using & contributing to Open Source initiatives. The Kotlin language & runtine as well as the Kodein Framework: everything is Open!"
                            }
            ).forEachIndexed { index, (quote, text) ->
                styledDiv {
                    css {
                        display = Display.flex
                        flexWrap = FlexWrap.wrap
                        maxWidth = 1200.px
                        margin(horizontal = LinearDimension.auto)
                        justifyContent = JustifyContent.center
                        if (index % 2 == 1)
                            flexDirection = FlexDirection.rowReverse
                    }

                    styledP {
                        css {
                            width = 450.px
                            margin(40.px, 10.px)
                            textAlign = TextAlign.left
                            fontSize = 1.9.em
                            maxWidth = 330.px
                            color = Color.kodeinOrange
                            before {
                                content = QuotedString("")
                                display = Display.block
                                width = 160.px
                                height = 0.px
                                borderTop(2.px, BorderStyle.solid, Color.black)
                                marginBottom = 28.px
                                marginLeft = 5.px
                            }
                        }

                        quote()
                    }
                    styledP {
                        css {
                            width = 450.px
                            margin(40.px, 10.px)
                            textAlign = TextAlign.left
                            fontWeight = FontWeight.w300
                            fontSize = 0.88.em
                            maxWidth = 330.px
                        }

                        text()
                    }
                }
            }
        }

    }

}