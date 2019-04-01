package net.kodein.workshop.frag

import kotlinx.css.*
import net.kodein.kotlinConfOrange
import net.kodein.mainpage.frag.comp.offers
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.b
import react.dom.br
import styled.css
import styled.styledA
import styled.styledH2

class WhenAndWhere : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        styledH2 {
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +"When And Where"
        }

        offers {
            "KotlinConf 2019" { +"The workshop will take place on" ; br {} ; b { +"december 4th 2019" } ; br {} ;  +"at " ; styledA(href = "https://kotlinconf.com/workshops/") { css { color = Color.kotlinConfOrange } ; +"KotlinConf Amsterdam" } }
            "Join us!" { +"Save your place!" ; br {} ; +"First come, first served," ; br {} ; +"so register now!" }
        }

    }

}