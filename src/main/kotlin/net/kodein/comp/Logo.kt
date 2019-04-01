package net.kodein.comp

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import styled.*

class Logo : RComponent<Logo.Props, RState>() {

    interface Props : RProps {
        var bold: String
        var light: String
        var sub: RBuilder.() -> Unit
        var href: String?
        var isSmall: Boolean?
        var hasTransition: Boolean?
        var smallMargin: LinearDimension?
    }

    override fun RBuilder.render() {

        val isSmall = props.isSmall ?: false
        val hasTransition = props.hasTransition ?: false

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                alignItems = Align.center
                justifyContent = JustifyContent.center

                if (isSmall) {
                    margin(top = 15.px, right = (props.smallMargin ?: 0.px))
                    media("(max-width: 880px)") {
                        marginRight = 0.px
                    }
                }
                if (hasTransition)
                    transition(duration = 0.3.s)
            }

            styledImg(alt = "Kodein logo", src = "imgs/logo-white.svg") {
                css {
                    display = Display.block
                    width = if (isSmall) 2.em else 5.55.em
                    height = if (isSmall) 1.7.em else 5.55.em
//                    paddingBottom = 1.88.em
                    if (isSmall)
                        marginTop = (-15).px
                    if (hasTransition)
                        transition(duration = 0.3.s)
                }
            }

            div {
                styledH1 {
                    css {
                        fontWeight = FontWeight.w700
                        fontSize = if (isSmall) 1.8.em else 2.98.em;
                        marginTop = (-20).px
                        textAlign = TextAlign.left
                        if (hasTransition)
                            transition(duration = 0.3.s)
                    }

                    styledA(href = props.href) {
                        css {
                            color = Color.white
                            textDecoration = TextDecoration.none
                        }

                        +props.bold

                        styledSpan {
                            css.fontWeight = FontWeight.w300
                            +props.light
                        }
                    }
                }
                styledH2 {
                    css {
                        fontWeight = FontWeight.w300
                        color = Color.white
                        fontSize = 1.38.em
                        marginTop = (-0.45).em
                        textAlign = TextAlign.left
                        paddingLeft = 2.px
                        height = 0.em
                        if (isSmall) {
                            opacity = 0
                            pointerEvents = PointerEvents.none
                        }
                        if (hasTransition)
                            transition(duration = 0.3.s)
                    }
                    (props.sub)()
                }
            }
        }

    }


}
