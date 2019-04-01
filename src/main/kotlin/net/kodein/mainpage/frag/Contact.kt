package net.kodein.mainpage.frag

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

class Contact : Text.Component<Text.Props, RState>(), MainPage.AnchorFragment {

    override val scrollTo = createRef<HTMLElement>()

    override fun RBuilder.render() {

        styledDiv {
            ref = scrollTo
            css {
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

                +-Text.ct_title
            }

            offers {
                (-Text.ct_contact) {
                    a(href = "mailto:contact@kodein.net") { +"contact@kodein.net" }
                    br {}
                    a(href = "tel:+33683545596") { +"+33 6 83 54 55 96" }
                }
                (-Text.ct_open) {
                    a(href = "http://kodein.org") { +"kodein.org" }
                }
                (-Text.ct_job_title) {
                    +-Text.ct_job_allin
                    br {}
                    a(href = "https://gist.github.com/SalomonBrys/df8aea72bff6d2c317b59ff82618c7ec") { +-Text.ct_job_join }
                }
            }
        }
    }
}