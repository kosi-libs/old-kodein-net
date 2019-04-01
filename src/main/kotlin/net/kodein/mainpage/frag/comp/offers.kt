package net.kodein.mainpage.frag.comp

import kotlinx.css.*
import react.RBuilder
import styled.*


class OffersBuilder {
    internal val list = ArrayList<Pair<String, RBuilder.() -> Unit>>()

    operator fun String.invoke(block: RBuilder.() -> Unit) { list += this to block }
}

fun RBuilder.offers(block: OffersBuilder.() -> Unit) {
    val builder = OffersBuilder().apply(block)

    styledUl {
        css {
            listStyleType = ListStyleType.none
            display = Display.flex
            flexWrap = FlexWrap.wrap
            justifyContent = JustifyContent.center
            margin(LinearDimension.auto)
            maxWidth = 800.px
        }
        builder.list.forEach { (title, content) ->
            styledLi {
                css {
                    maxWidth = 310.px
                    margin(28.px, 20.px)
                }
                styledH3 {
                    css {
                        fontSize = 1.07.em
                        marginBottom = 30.px
                    }
                    +title
                }
                styledP {
                    css {
                        fontSize = 1.05.em
                        fontWeight = FontWeight.w300
                    }
                    content()
                }
            }
        }
    }
}
