package net.kodein

import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.dom.addClass
import kotlin.dom.hasClass
import kotlin.dom.removeClass
import kotlin.math.max

@Suppress("unused")
fun main(args: Array<String>) {
    window.onload = { main() }
}

fun main() {
    val header = document.querySelector("div#header")!! as HTMLElement
    val headerTitle = document.querySelector("div#header h1")!! as HTMLElement
    val headerSubtitle = document.querySelector("div#header h2")!! as HTMLElement
    val body = document.body!!

    var headerIsSmall = false
    fun setHeaderPos(isFirst: Boolean = false) {
        if (isFirst || body.scrollTop < 580 || header.style.height != "40px") {
            val height = max(40, 580 - body.scrollTop.toInt())
            header.style.height = "${height}px"
            val scroll = 580 - height
            header.style.backgroundPosition = "center ${-220 - (scroll / 4)}px"

            if (height <= 110 && !headerIsSmall) {
                headerIsSmall = true
                if (!isFirst) {
                    headerTitle.addClass("transition")
                    headerSubtitle.addClass("transition")
                }
                header.addClass("small")
            }
            else if (height > 110 && headerIsSmall) {
                headerIsSmall = false
                if (!isFirst) {
                    headerTitle.addClass("transition")
                    headerSubtitle.addClass("transition")
                }
                header.removeClass("small")
            }
        }
    }

    setHeaderPos(true)


    val kotlinDiv = document.querySelector("div.kotlin.big")!! as HTMLElement

    fun setKotlinPos() {
        val startScroll = kotlinDiv.offsetTop - window.innerHeight
        val endScroll = kotlinDiv.offsetTop + kotlinDiv.clientHeight

        if (body.scrollTop < startScroll || body.scrollTop > endScroll)
            return

        val scrollSpan = endScroll - startScroll
        val factor = 1 - (body.scrollTop - startScroll) / scrollSpan

        val endPos = -1100 + kotlinDiv.clientHeight
        val bgPos = (factor * endPos).toInt()
        kotlinDiv.style.backgroundPosition = "center ${bgPos}px"
    }

    setKotlinPos()


    @Suppress("UNCHECKED_CAST")
    val anchors = document.querySelectorAll("div#header a").asList().map {
        it as HTMLAnchorElement
        val id = it.href.substringAfter('#')
        if (id.isBlank()) {
            it to { 200.0 }
        }
        else {
            val anchor = document.getElementById(id) as HTMLElement
            it to { anchor.offsetTop.toDouble() - 60.0 }
        }
    }

    document.onscroll = {
        setHeaderPos()
        setKotlinPos()
    }


    anchors.forEach { (el, offset) ->
        el.onclick = {
            window.scrollTo(ScrollToOptions(0.0, offset(), ScrollBehavior.SMOOTH))
            false
        }
    }


    val strip = document.querySelector("div#strip") as HTMLElement
    strip.style.display = "block"
}
