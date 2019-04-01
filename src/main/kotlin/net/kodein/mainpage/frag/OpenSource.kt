package net.kodein.mainpage.frag

import kotlinx.css.*
import net.kodein.Text
import net.kodein.kodeinOrange
import net.kodein.mainpage.frag.comp.offers
import react.RBuilder
import react.RState
import react.dom.br
import react.dom.p
import react.dom.span
import styled.css
import styled.styledDiv
import styled.styledP
import kotlin.js.Date
import kotlinx.css.span as subSpan
import kotlinx.css.p as subP

class OpenSource : Text.Component<Text.Props, RState>() {

    override fun RBuilder.render() {

        styledDiv {
            css {
                margin(bottom = 40.px)
            }
            offers {
                (-Text.os_multi_title) { +-Text.os_multi_content }
                (-Text.os_mobile_title) { +-Text.os_mobile_content }
                (-Text.os_open_title) { +-Text.os_open_content }
                (-Text.os_evw_title) { +-Text.os_evw_content }
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
                    +"= ${Date().getFullYear() - 2015} ${-Text.os_years}"
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
                    (-Text.os_text_1)()
                }

                p {
                    (-Text.os_text_2)()
                }

                p {
                    (-Text.os_text_3)()
                }
            }
        }
    }
}