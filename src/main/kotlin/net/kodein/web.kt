package net.kodein

import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.dom.addClass
import kotlin.dom.removeClass
import kotlin.math.max

@Suppress("unused")
fun main(args: Array<String>) {
    window.onload = { main() }
}

fun main() {
    val body = document.body!!

    val headerDiv = document.querySelector("div#header")!! as HTMLElement
    val logoDiv = document.querySelector("div#logo")!! as HTMLElement
    val logoImg = document.querySelector("div#logo img")!! as HTMLElement
    val headerTitle = document.querySelector("div#logo h1")!! as HTMLElement
    val headerSubtitle = document.querySelector("div#logo h2")!! as HTMLElement

    var headerIsSmall = false
    fun setHeaderPos(isFirst: Boolean = false) {
        if (isFirst || body.scrollTop < 585 || headerDiv.style.height != "40px") {
            val height = max(40, 585 - body.scrollTop.toInt())
            headerDiv.style.height = "${height}px"
            val scroll = 585 - height
            headerDiv.style.backgroundPosition = "center ${-(scroll / 2.9)}px"

            if (height <= 165 && !headerIsSmall) {
                headerIsSmall = true
                if (!isFirst) {
                    logoDiv.addClass("transition")
                    logoImg.addClass("transition")
                    headerTitle.addClass("transition")
                    headerSubtitle.addClass("transition")
                }
                headerDiv.addClass("small")
            }
            else if (height > 165 && headerIsSmall) {
                headerIsSmall = false
                if (!isFirst) {
                    logoDiv.addClass("transition")
                    logoImg.addClass("transition")
                    headerTitle.addClass("transition")
                    headerSubtitle.addClass("transition")
                }
                headerDiv.removeClass("small")
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

        val heightStr = window.getComputedStyle(kotlinDiv).backgroundSize.split(" ")[1]
        val height = heightStr.substring(0, heightStr.length - 2).toInt()

        val endPos = -height + kotlinDiv.clientHeight
        val bgPos = (factor * (endPos - kotlinDiv.clientHeight)).toInt() + (kotlinDiv.clientHeight / 2)

        kotlinDiv.style.backgroundPosition = "center ${bgPos}px"
    }

    setKotlinPos()


    document.onscroll = {
        setHeaderPos()
        setKotlinPos()
    }


    @Suppress("UNCHECKED_CAST")
    val anchors = document.querySelectorAll("a.goto").asList().map {
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

    anchors.forEach { (el, offset) ->
        el.onclick = {
            window.scrollTo(ScrollToOptions(0.0, offset(), ScrollBehavior.SMOOTH))
            false
        }
    }


    val strip = document.querySelector("div#strip") as HTMLElement
    strip.style.display = "block"
}
