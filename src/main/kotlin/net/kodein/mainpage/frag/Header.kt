package net.kodein.mainpage.frag

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import net.kodein.Text
import net.kodein.comp.Logo
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import react.dom.a
import react.dom.b
import react.dom.p
import styled.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.math.max
import kotlinx.css.a as subA

class Header : Text.Component<MainPage.Props, Header.State>() {

    interface State : RState {
        var isSmall: Boolean
        var hasTransition: Boolean
    }

    override fun State.init() {
        isSmall = false
        hasTransition = false
    }

    val div = createRef<HTMLDivElement>()

    override fun RBuilder.render() {
        styledDiv {
            ref = div
            css {
                height = 585.px
                backgroundImage = Image("url(imgs/background.png)")
                backgroundRepeat = BackgroundRepeat.repeat
                backgroundSize = "1040px"
                display = Display.flex
                flexDirection = FlexDirection.column
                justifyContent = JustifyContent.center
                alignItems = Align.center
                position = Position.fixed
                width = 100.pct
                maxWidth = 1040.px
                top = 0.px
                overflow = Overflow.hidden
                boxShadow(Color.gray, blurRadius = 3.px)
                put("clipPath", "inset(0px 0px -5px 0)")
            }

            styledDiv {
                css {
                    position = Position.absolute
                    top = 0.px
                    left = 10.px
                    height = 40.px
                    color = Color.white
                    fontSize = 0.8.em
                    cursor = Cursor.default
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignContent = Align.center
                    justifyContent = JustifyContent.center

                    subA {
                        color = Color.white
                        textDecoration = TextDecoration.none
                        fontWeight = FontWeight.normal
                        cursor = Cursor.pointer
                    }
                }

                p {
                    fun langHref(lang: String) = "#/home/$lang" + if (props.anchor != null) "/${props.anchor}" else ""

                    if (props.lang == "en") b { +"EN" } else a(href = langHref("en")) { +"EN" }
                    +" | "
                    if (props.lang == "fr") b { +"FR" } else a(href = langHref("fr")) { +"FR" }
                }
            }

            styledDiv {
                css {
                    position = Position.absolute
                    top = 0.px
                    right = 0.px
                    display = Display.flex
                    justifyContent = JustifyContent.flexEnd
                    alignItems = Align.center
                    padding(0.px, 6.px)
                    fontSize = 0.7.em

                    subA {
                        display = Display.block
                        fontWeight = FontWeight.w700
                        padding(14.px, 6.px)
                        textDecoration = TextDecoration.none
                        color = Color.white
                        cursor = Cursor.pointer
                        transition("background-color", duration = 0.15.s)

                        hover {
                            backgroundColor = Color("#FFFFFF44")
                        }
                    }

                    media("(max-width: 880px)") {
                        display = Display.none
                    }

                }
                a(href = "#/home/${props.lang}/training") { +(-Text.training_and_consulting).toUpperCase() }
                a(href = "#/home/${props.lang}/kotlin") { +"KOTLIN/EVERYWHERE" }
                a(href = "#/home/${props.lang}/opensource") { +"OPEN SOURCE" }
                a(href = "#/home/${props.lang}/contact") { +(-Text.contact_and_community).toUpperCase() }
            }

            child(Logo::class) {
                attrs {
                    bold = "KODEIN"
                    light = "Koders"
                    sub = { +"painless technology" }
                    href = "#/home/${props.lang}"
                    isSmall = state.isSmall
                    smallMargin = 465.px
                    hasTransition = state.hasTransition
                }
            }
        }

        styledSpan {
            css {
                display = Display.block
                height = 585.px
            }
        }
    }

    private var headerHeight = 0

    private fun setHeaderPos(isFirst: Boolean = false) {
        val scrollTop = window.scrollY
        if (isFirst || scrollTop < 585 || headerHeight != 40) {
            headerHeight = max(40, 585 - scrollTop.toInt())
            val scroll = 585 - headerHeight
            val isSmall = headerHeight <= 165

            div.current!!.style.apply {
                height = "${headerHeight}px"
                backgroundPosition = "center ${-(scroll / 2.9)}px"
            }

            if (state.isSmall != isSmall || state.hasTransition != !isFirst)
                setState {
                    this.isSmall = isSmall
                    this.hasTransition = !isFirst
                }
        }
    }

    private val scrollCallback: (Event) -> Unit = { setHeaderPos() }

    override fun componentDidMount() {
        setHeaderPos(true)
        window.setTimeout({ setState { hasTransition = true } }, 500)
        document.addEventListener("scroll", scrollCallback)
    }

    override fun componentWillUnmount() {
        document.removeEventListener("scroll", scrollCallback)
    }
}
