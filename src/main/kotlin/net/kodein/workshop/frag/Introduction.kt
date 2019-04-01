package net.kodein.workshop.frag

import kotlinx.css.*
import net.kodein.Text
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.br
import react.dom.p
import styled.*

class Introduction : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        styledH1 {
            css {
                fontWeight = FontWeight.w700
                fontSize = 1.9.em
                margin(40.px)
            }

            +"Your business, everywhere."
        }

        styledDiv {
            css {
                maxWidth = 750.px
                margin(LinearDimension.auto)
                padding(horizontal = 50.px)
                textAlign = TextAlign.left

                kotlinx.css.p {
                    margin(vertical = 1.em)
                }
            }

            p {
                +"Kotlin is Everywhere! "
                br {}
                +"However, the language is just one part of the story: the other part being each targeted platform. "
                +"With Kotlin/JVM we can target Android, with Kotlin/Native iOS, and with Kotlin/JS the mobile web. "
                +"So, using Kotlin/Everywhere ensures that half of the story can be written once, tested once and deployed everywhere. "
            }

            p {
                +"But how do we architecture the application so that both halves can work together? "
                br {}
                +"How do we build? Test? Deploy? "
            }

            p {
                +"In this workshop, we will cover everything we need to write the business code of our application once and connect it to the presentation layer of the three major mobile platforms (Android, iOS, the Web). "
                +"We will cover the tools available to write, build, test and deploy multiplatform code, the architecture patterns and language tools that makes it easy to use it everywhere, and the multiplatform libraries that allows us to focus on the business of your application. "
            }
        }
    }

}