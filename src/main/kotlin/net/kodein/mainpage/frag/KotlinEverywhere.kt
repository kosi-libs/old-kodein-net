package net.kodein.mainpage.frag

import kotlinx.css.*
import kotlinx.css.properties.borderTop
import net.kodein.Text
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLElement
import react.RBuilder
import react.RState
import react.createRef
import react.dom.b
import react.dom.br
import styled.*
import kotlinx.css.b as subB

class KotlinEverywhere : Text.Component<Text.Props, RState>(), MainPage.AnchorFragment {

    override val scrollTo = createRef<HTMLElement>()

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

                +-Text.ke_title
                br {}
                b { +-Text.ke_subtitle }
            }

            listOf(
                    Text.ke_code_title to Text.ke_code_content,
                    Text.ke_kodein_title to Text.ke_kodein_content,
                    Text.ke_open_title to Text.ke_open_content
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

                        (-quote)()
                    }
                    styledP {
                        css {
                            width = 450.px
                            margin(40.px, 10.px)
                            textAlign = TextAlign.left
                            fontWeight = FontWeight.w300
                            fontSize = 0.88.em
                            maxWidth = 330.px
                            subB {
                                fontWeight = FontWeight.w500
                            }
                        }

                        (-text)()
                    }
                }
            }
        }

    }

}