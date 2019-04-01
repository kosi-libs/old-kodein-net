package net.kodein.mainpage.frag

import kotlinx.css.*
import net.kodein.Text
import net.kodein.comp.Logo
import net.kodein.kodeinGreen
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import styled.*
import kotlin.browser.document
import kotlin.browser.window

class KodeinFramework : RComponent<Text.Props, RState>(), MainPage.AnchorFragment {

    val div = createRef<HTMLDivElement>()
    override val scrollTo get() = div

    override fun RBuilder.render() {
        styledDiv {
            ref = div
            css {
                backgroundColor = Color.kodeinGreen
                color = Color.white
                padding(vertical = 50.px)
                backgroundImage = Image("url('imgs/opensource-background.svg')")
                backgroundRepeat = BackgroundRepeat.noRepeat
                backgroundPosition = "center"
                backgroundSize = "1100px 1100px"

                fontSize = 0.9.em

                media("(max-width: 560px)") {
                    fontSize = 0.8.em
                }
            }

            child(Logo::class) {
                attrs {
                    bold = "KODEIN"
                    light = "Framework"
                    sub = {
                        +"painless "
                        styledImg(src = "imgs/kotlin-white.svg") {
                            css {
                                width = 0.68.em
                                height = 0.68.em
                            }
                        }
                        +"Kotlin, everywhere."
                    }
                    href = "https://kodein.org"
                }
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    justifyContent = JustifyContent.center
                    maxWidth = 34.em
                    margin(LinearDimension.auto)
                    marginTop = 1.5.em
                }

                listOf("ANDROID", "iOS", "WEB", "SERVER", "DESKTOP").forEach {
                    styledP {
                        css {
                            fontWeight = FontWeight.w600
                            backgroundColor = Color.lightGray
                            color = Color.black
                            fontSize = 0.5.em
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