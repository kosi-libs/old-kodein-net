package net.kodein.mainpage

import net.kodein.mainpage.frag.*
import net.kodein.Text
import org.w3c.dom.*
import react.*
import kotlin.browser.window

class MainPage : RComponent<MainPage.Props, RState>() {

    interface Props : Text.Props {
        var anchor: String?
    }

    interface AnchorFragment {
        val scrollTo: RReadableRef<HTMLElement>
    }

    private val refs = listOf("training", "kotlin", "opensource", "contact").associateWith { createRef<AnchorFragment>() }

    fun RElementBuilder<Text.Props>.conf(refKey: String? = null) {
        if (refKey != null)
            ref = refs.getValue(refKey)
        attrs {
            lang = props.lang
        }
    }

    override fun RBuilder.render() {
        child(Header::class) { conf() }
        child(Introduction::class) { conf() }
        child(TrainingAndConsulting::class) { conf("training") }
        child(KotlinEverywhere::class) { conf("kotlin") }
        child(KodeinFramework::class) { conf("opensource") }
        child(OpenSource::class) { conf() }
        child(Contact::class) { conf("contact") }
    }

    private fun getOffset(anchor: String?): Int {
        anchor ?: return 200
        val scrollTo = refs[anchor]?.current?.scrollTo?.current ?: return -1
        return scrollTo.offsetTop - 60
    }

    override fun componentDidMount() {
        if (props.anchor != null) {
            val offset = getOffset(props.anchor)
            if (offset != -1)
                window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.INSTANT))
        }
    }

    override fun componentWillReceiveProps(nextProps: Props) {
        if (props.anchor == nextProps.anchor)
            return

        val offset = getOffset(nextProps.anchor)
        if (offset != -1)
            window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
    }
}
