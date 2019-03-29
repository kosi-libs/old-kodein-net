package net.kodein.workshop

import kotlinx.css.*
import net.kodein.kodeinOrange
import net.kodein.mainpage.fragment.comp.offers
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledP
import kotlin.js.Date
import kotlinx.css.span as subSpan
import kotlinx.css.p as subP

class Workshop : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        styledDiv {
            css {
                margin(bottom = 40.px)
            }

            h1 { +"Workshop!" }

        }
    }
}