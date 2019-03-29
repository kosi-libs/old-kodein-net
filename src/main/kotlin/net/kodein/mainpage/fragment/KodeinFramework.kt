package net.kodein.mainpage.fragment

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.DIV
import net.kodein.kodeinGreen
import net.kodein.kodeinOrange
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.*
import react.dom.div
import react.dom.img
import styled.*
import kotlin.browser.document
import kotlin.browser.window

class KodeinFramework : RComponent<MainPage.FragmentProps, RState>(), MainPage.AnchorFragment {

    val div = createRef<HTMLDivElement>()
    override val scrollTo get() = div

    override fun RBuilder.render() {
        styledDiv {
            ref = div
            css {
                backgroundColor = Color.kodeinGreen
                color = Color.white
                padding(100.px, 50.px)
                backgroundImage = Image("url('imgs/opensource-background.svg')")
                backgroundRepeat = BackgroundRepeat.noRepeat
                backgroundPosition = "center"
                backgroundSize = "1100px 1100px"
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignItems = Align.center
                    justifyContent = JustifyContent.center
                }

                styledImg(alt = "Kodein logo", src = "imgs/logo-white.svg") {
                    css {
                        display = Display.block
                        width = 5.55.em
                        height = 5.55.em
                        paddingBottom = 1.88.em
                    }
                }

                div {
                    styledH1 {
                        css {
                            fontWeight = FontWeight.w700
                            fontSize = 2.98.em;
                            marginTop = (-20).px
                            textAlign = TextAlign.left
                        }

                        styledA {
                            css {
                                color = Color.white
                                textDecoration = TextDecoration.none
                            }

                            +"KODEIN"

                            styledSpan {
                                css.fontWeight = FontWeight.w300
                                +"Framework"
                            }
                        }
                    }
                    styledH2 {
                        css {
                            fontWeight = FontWeight.w300
                            color = Color.white
                            fontSize = 1.38.em
                            marginTop = (-0.45).em
                            textAlign = TextAlign.left
                            paddingLeft = 2.px;
                        }
                        +"painless "
                        styledImg(src = "imgs/kotlin-white.svg") {
                            css {
                                width = 0.68.em
                                height = 0.68.em
                            }
                        }
                        +"Kotlin, everywhere."
                    }
                }


            }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    justifyContent = JustifyContent.center
                }

                listOf("ANDROID", "iOS", "WEB", "SERVER", "DESKTOP").forEach {
                    styledP {
                        css {
                            fontWeight = FontWeight.w600
                            backgroundColor = Color.lightGray
                            color = Color.black
                            fontSize = 0.6.em
                            margin(0.2.em)
                            width = 13.em
                            borderRadius = 0.5.em
                            padding(vertical = 0.7.em)
                        }
                        +it
                    }
                }
            }
        }

    }

    fun setKotlinPos() {
        val div = div.current!!
        val startScroll = div.offsetTop - window.innerHeight
        val endScroll = div.offsetTop + div.clientHeight

        if (window.scrollY < startScroll || window.scrollY > endScroll)
            return

        val scrollSpan = endScroll - startScroll
        val factor = 1 - (window.scrollY - startScroll) / scrollSpan

        val heightStr = window.getComputedStyle(div).backgroundSize.split(" ")[1]
        val height = heightStr.substring(0, heightStr.length - 2).toInt()

        val endPos = -height + div.clientHeight
        val bgPos = (factor * (endPos - div.clientHeight)).toInt() + (div.clientHeight / 2)

        div.style.backgroundPosition = "center ${bgPos}px"
    }

    private val scrollCallback: (Event) -> Unit = { setKotlinPos() }

    override fun componentDidMount() {
        setKotlinPos()
        document.addEventListener("scroll", scrollCallback)
    }

    override fun componentWillUnmount() {
        document.removeEventListener("scroll", scrollCallback)
    }

}