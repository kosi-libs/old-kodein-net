package net.kodein.mainpage.frag

import kotlinx.css.Color
import kotlinx.css.FontWeight
import kotlinx.css.em
import kotlinx.css.px
import net.kodein.Text
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import net.kodein.mainpage.frag.comp.offers
import org.w3c.dom.HTMLElement
import react.*
import react.dom.br
import styled.css
import styled.styledA
import styled.styledH2

class TrainingAndConsulting : Text.Component<Text.Props, RState>(), MainPage.AnchorFragment {

    override val scrollTo = createRef<HTMLElement>()

    override fun RBuilder.render() {

        styledH2 {
            ref = scrollTo
            css {
                fontWeight = FontWeight.w200
                fontSize = 1.9.em
                marginTop = 80.px
            }
            +Text.training_and_consulting[props.lang]
        }

        offers {
            (-Text.tc_cert_title) { +-Text.tc_cert_content }
            (-Text.tc_train_title) { +-Text.tc_train_content }
            (-Text.tc_work_title) {
                +-Text.tc_work_content
                br {}
                styledA(href = "#/workshop") {
                    css {
                        color = Color.kodeinOrange
                    }
                    +-Text.more_information
                }
            }
            (-Text.tc_arch_title) { +-Text.tc_arch_content }
        }

    }
}