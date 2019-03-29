package net.kodein

import net.kodein.mainpage.MainPage
import net.kodein.workshop.Workshop
import org.w3c.dom.ScrollRestoration
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.hashRouter
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.window

class App : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        hashRouter {
            switch {
                route<MainPage.Props>("/home/:lang/:anchor?") {
                    child(MainPage::class) {
                        attrs {
                            lang = it.match.params.lang
                            anchor = it.match.params.anchor
                        }
                    }
                }
                route("/workshop", Workshop::class, exact = true)

                val lang = if (window.navigator.language.startsWith("fr-")) "fr" else "en"
                redirect("/", "/home/$lang")
                redirect("/home", "/home/$lang")
            }
        }
    }

}
