package net.kodein.mainpage.fragment

import kotlinx.css.Color
import kotlinx.css.FontWeight
import kotlinx.css.em
import kotlinx.css.px
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import net.kodein.mainpage.fragment.comp.offers
import org.w3c.dom.HTMLElement
import react.*
import react.dom.a
import react.dom.br
import styled.css
import styled.styledA
import styled.styledH2

class TrainingAndConsulting : RComponent<MainPage.FragmentProps, RState>(), MainPage.AnchorFragment {

    override val scrollTo = createRef<HTMLElement>()

    override fun RBuilder.render() {

        styledH2 {
            ref = scrollTo
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +"Training & Consulting"
        }

        offers {
            "Jetbrains certified" { +"First trainer in Europe to be certified by Jetbrains for Kotlin training." }
            "Professional training" { +"Asynchronous & multiplatform programming. Native compilation. Migration to modern Kotlin." }
            "KotlinConf Workshop" {
                +"Join us to the multiplatform KotlinConf 2019 workshop!"
                br {}
                styledA(href = "#/workshop") {
                    css {
                        color = Color.kodeinOrange
                    }
                    +"More information"
                }
            }
            "Architecture consultancy" { +"Creation, documentation and deployment of cutting edge Open Source architectures." }
        }

    }
}