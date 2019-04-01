package net.kodein.workshop

import net.kodein.workshop.frag.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import kotlinx.css.p as subP
import kotlinx.css.span as subSpan

class Workshop : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        child(Header::class)  {}
        child(Introduction::class)  {}
        child(Requirements::class) {}
        child(Topics::class) {}
        child(WhoWeAre::class) {}
        child(WhenAndWhere::class) {}
        child(Contact::class) {}
    }
}