package net.kodein.workshop.frag

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import net.kodein.Text
import net.kodein.comp.Logo
import net.kodein.kodeinGreen
import net.kodein.kotlinConfOrange
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import react.dom.a
import react.dom.b
import react.dom.br
import react.dom.p
import styled.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.math.max
import kotlinx.css.a as subA

class Header : RComponent<RProps, Header.State>() {

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
                backgroundColor = Color.kotlinConfOrange
                backgroundImage = Image("url('imgs/opensource-background.svg')")
                backgroundRepeat = BackgroundRepeat.repeat
                backgroundRepeat = BackgroundRepeat.noRepeat
                backgroundPosition = "left"
                backgroundSize = "585px 585px"
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
                    right = 10.px
                    padding(0.px, 6.px)
                    display = Display.flex
                    height = 40.px
                    alignItems = Align.center
                    fontSize = 0.9.em
                    fontWeight = FontWeight.w300
                    color = Color.white
               }
                +"by "
                styledA (href = "#/") {
                    css {
                        color = Color.white
                    }
                    styledB {
                        css {
                            fontWeight = FontWeight.w700
                        }
                        +"KODEIN"
                    }
                    +"Koders"
                }
            }

            child(Logo::class) {
                attrs {
                    bold = "2019"
                    light = "Workshop"
                    sub = { b { +"Kotlin" } ; +"/Everywhere" ; br {} ; b { +"Kotlin" } ; +"Conf Amsterdam" }
                    isSmall = state.isSmall
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
                backgroundPosition = "left ${-(scroll / 2.9)}px"
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
