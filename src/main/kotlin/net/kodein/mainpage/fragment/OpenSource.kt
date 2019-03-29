package net.kodein.mainpage.fragment

import kotlinx.css.*
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import net.kodein.mainpage.fragment.comp.offers
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.b
import react.dom.br
import react.dom.p
import react.dom.span
import styled.css
import styled.styledDiv
import styled.styledP
import kotlin.js.Date
import kotlinx.css.span as subSpan
import kotlinx.css.p as subP

class OpenSource : RComponent<MainPage.FragmentProps, RState>() {

    override fun RBuilder.render() {

        styledDiv {
            css {
                margin(bottom = 40.px)
            }
            offers {
                "Multiplatform" { +"First High-level Kotlin multiplatform framework." }
                "Mobile first" { +"Made with Android, iOS & the mobile Web in mind." }
                "Open Source" { +"Safe, documented, thoroughly tested and widely used." }
                "Everywhere" { +"Compatible with mobile, server, desktop & embedded targets." }
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    fontSize = 1.4.em
                    alignItems = Align.center
                    justifyContent = JustifyContent.center
                    padding(30.px)
                    backgroundColor = Color.kodeinOrange
                    color = Color.white
                }

                styledP {
                    css {
                        fontSize = 1.6.em
                    }
                    +"+"
                }
                styledP {
                    css {
                        textAlign = TextAlign.left
                        fontWeight = FontWeight.w700
                        padding(horizontal = 10.px)
                        subSpan {
                            fontWeight = FontWeight.w300
                        }
                    }
                    +"KODEIN"
                    span { +"Koders" }
                    br {}
                    +"KODEIN"
                    span { +"Framework" }
                }
                styledP {
                    css {
                        fontSize = 1.4.em
                    }
                    +"= ${Date().getFullYear() - 2015} years!"
                }
            }

            styledDiv {
                css {
                    maxWidth = 800.px
                    margin(LinearDimension.auto)
                    padding(top = 20.px)
                    textAlign = TextAlign.left
                    fontSize = 1.08.em
                    fontWeight = FontWeight.w300

                    subP {
                        padding(10.px)
                    }
                }

                p {
                    +"For business code units, using the Kotlin language & the Kodein framework unlocks an amazing potential: the ability to truly develop once, test once and deploy everywhere."
                    br {}
                    +"In addition to JVM and Android bytecode, Kotlin & Kodein can target Javascript as well as native iOS assembly."
                }

                p {
                    b { +"KODEIN" }
                    +"Koders is at the root of the #1 multi-platform framework that allows a developer to create business code units that can run on Android, iOS, the Web, server and desktop softwares."
                }

                p {
                    +"Want to know more? Learn this amazing technology? "
                    b { +"Contact us!" }
                }
            }
        }
    }
}