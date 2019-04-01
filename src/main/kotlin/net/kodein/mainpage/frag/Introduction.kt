package net.kodein.mainpage.frag

import kotlinx.css.*
import net.kodein.Text
import react.RBuilder
import react.RComponent
import react.RState
import styled.*

class Introduction : RComponent<Text.Props, RState>() {

    override fun RBuilder.render() {
        styledH1 {
            css {
                fontWeight = FontWeight.w700
                fontSize = 1.9.em
                margin(40.px)
            }

            +Text.kotlin_experts[props.lang]
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
                    "training" to Text.head_training,
                    "kotlin" to Text.head_certif,
                    "layers" to Text.head_kotlin,
                    "opensource" to Text.head_framework
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
                        content[props.lang]()
                    }
                }
            }
        }
    }

}