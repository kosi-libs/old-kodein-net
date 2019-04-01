package net.kodein

import net.kodein.mainpage.MainPage
import net.kodein.workshop.Workshop
import org.w3c.dom.History
import org.w3c.dom.ScrollRestoration
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.*
import kotlin.browser.window

class App : RComponent<RProps, RState>() {

    private var prev: String? = null

    private fun update(page: String) {
        if (page == prev) return
        prev = page
        window.scrollTo(0.0, 0.0)
    }

    override fun RBuilder.render() {
        hashRouter {
            switch {
                route<MainPage.Props>("/home/:lang/:anchor?") {
                    update("home")
                    child(MainPage::class) {
                        attrs {
                            lang = it.match.params.lang
                            anchor = it.match.params.anchor
                        }
                    }
                }
                route<RProps>("/workshop", exact = true) {
                    update("workshop")
                    child(Workshop::class) {}
                }

                val lang = if (window.navigator.language.startsWith("fr-")) "fr" else "en"
                redirect("/", "/home/$lang")
                redirect("/home", "/home/$lang")
            }
        }
    }

}
