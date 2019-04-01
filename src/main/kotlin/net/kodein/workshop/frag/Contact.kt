package net.kodein.workshop.frag

import kotlinx.css.*
import net.kodein.Text
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import net.kodein.mainpage.frag.comp.offers
import org.w3c.dom.HTMLElement
import react.*
import react.dom.a
import react.dom.br
import styled.css
import styled.styledDiv
import styled.styledH2
import kotlinx.css.a as subA
import kotlinx.css.span as subSpan

class Contact : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        styledDiv {
            css {
                marginTop = 80.px
                backgroundColor = Color.kodeinOrange
                background = "linear-gradient(135deg, #e8441f 0%, #921f81 100%)"
                color = Color.white;
                padding(top = 50.px, bottom = 90.px)

                subA {
                    color = Color.white
                }
            }

            styledH2 {
                css {
                    fontWeight = FontWeight.w200
                    fontSize = 1.9.em
                }

                +"Contact"
            }

            offers {
                "A question?" {
                    a(href = "mailto:contact@kodein.net") { +"contact@kodein.net" }
                    br {}
                    a(href = "tel:+33683545596") { +"+33 6 83 54 55 96" }
                }
                "KotlinConf 2019" {
                    a(href = "https://kotlinconf.com") { +"https://kotlinconf.com" }
                }
            }
        }
    }
}