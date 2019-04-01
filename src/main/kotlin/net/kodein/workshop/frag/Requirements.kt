package net.kodein.workshop.frag

import kotlinx.css.FontWeight
import kotlinx.css.br
import kotlinx.css.em
import kotlinx.css.px
import net.kodein.mainpage.frag.comp.offers
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.b
import react.dom.br
import styled.css
import styled.styledH2

class Requirements : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        styledH2 {
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +"Requirements"
        }

        offers {
            "iOS" { +"An Apple laptop is needed for iOS but " ; b { +"not required" } ; +" if you don't intend to target it." }
            "Platforms" { +"Knowledge of mobile platforms (Android, iOS, Web) is better but " ; b { +"not required" } ; +"." }
            "Kotlin" { +"Knowledge of basic Kotlin syntax and features " ; b { +"is required" } ; +"." }
            "Fun" { +"Being light hearted, inclusive and fun is " ; b { +"absolutely required" } ; +"!" }
        }

    }

}