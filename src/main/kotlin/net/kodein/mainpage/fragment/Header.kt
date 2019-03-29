package net.kodein.mainpage.fragment

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import net.kodein.mainpage.MainPage
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import react.dom.a
import react.dom.b
import react.dom.div
import react.dom.p
import styled.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.math.max
import kotlinx.css.a as subA

class Header : RComponent<MainPage.Props, Header.State>() {

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
                }
                a(href = "#/home/${props.lang}/training") { +"TRAINING & CONSULTING" }
                a(href = "#/home/${props.lang}/kotlin") { +"KOTLIN/EVERYWHERE" }
                a(href = "#/home/${props.lang}/opensource") { +"OPEN SOURCE" }
                a(href = "#/home/${props.lang}/contact") { +"CONTACT & COMMUNITY" }
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignItems = Align.center
                    if (state.isSmall)
                        margin(top = 48.px, right = 550.px)
                    if (state.hasTransition) {
                        transition(duration = 0.3.s)
                    }
                }

                styledImg(alt = "Kodein logo", src = "imgs/logo-white.svg") {
                    css {
                        display = Display.block
                        width = if (state.isSmall) 2.em else 5.55.em
                        height = if (state.isSmall) 1.7.em else 5.55.em
                        paddingBottom = 1.88.em
                        if (state.isSmall)
                            marginTop = (-12).px
                        if (state.hasTransition)
                            transition(duration = 0.3.s)
                    }
                }

                div {
                    styledH1 {
                        css {
                            fontWeight = FontWeight.w700
                            fontSize = if (state.isSmall) 1.8.em else 2.98.em;
                            marginTop = (-20).px
                            textAlign = TextAlign.left
                            if (state.hasTransition)
                                transition(duration = 0.3.s)
                        }

                        styledA(href = "#/home/${props.lang}") {
                            css {
                                color = Color.white
                                textDecoration = TextDecoration.none
                            }

                            +"KODEIN"

                            styledSpan {
                                css.fontWeight = FontWeight.w300
                                +"Koders"
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
                            if (state.isSmall) {
                                opacity = 0
                                pointerEvents = PointerEvents.none
                            }
                            if (state.hasTransition)
                                transition(duration = 0.3.s)
                        }
                        +"painless technology"
                    }
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
        document.addEventListener("scroll", scrollCallback)
    }

    override fun componentWillUnmount() {
        document.removeEventListener("scroll", scrollCallback)
    }
}
