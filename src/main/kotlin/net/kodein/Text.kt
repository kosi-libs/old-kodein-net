package net.kodein

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.b
import react.dom.br

object Text {

    interface Props : RProps {
        var lang: String
    }

    abstract class Component<P: Props, S: RState> : RComponent<P, S>() {
        operator fun <T> Entry<T>.unaryMinus() = get(props.lang)
    }

    class Entry<T>(val en: T, val fr: T) {
        operator fun get(lang: String): T = when (lang) {
            "fr" -> fr
            else -> en
        }

    }

    fun e(en: String, fr: String) = Entry(en, fr)
    fun e(en: RBuilder.() -> Unit, fr: RBuilder.() -> Unit) = Entry(en, fr)

    val training_and_consulting = e(
            "Training & Consulting",
            "Formation & Consulting"
    )

    val contact_and_community = e(
            "Contact",
            "Contact"
    )

    val kotlin_experts = e(
            "We are Kotlin experts.",
            "L'expertise Kotlin."
    )


    val more_information = e(
            "More information",
            "En savoir plus"
    )

    val head_training = e(
            { +"Training & consulting services." },
            { +"Formation & services de consulting." }
    )

    val head_certif = e(
            { +"Jetbrains certified professional training." },
            { +"Formation professionelle certifiée par Jetbrains." }
    )

    val head_kotlin = e(
            { b { +"Kotlin" }; +"/Everywhere:"; br {}; +"all mobile platforms." },
            { b { +"Kotlin" }; +"/Everywhere:"; br {}; +"toutes plateformes mobile." }
    )

    val head_framework = e(
            { +"Open Source multi-platform framework." },
            { +"Framework Open Source multi-platformes." }
    )

    val tc_cert_title = e(
            "Jetbrains certified",
            "Certifié par Jetbrains"
    )
    val tc_cert_content = e(
            "First trainer in Europe to be certified by Jetbrains for Kotlin training.",
            "Premier formateur en Europe Certifié par Jetbrains pour la formation Kotlin."
    )

    val tc_train_title = e(
            "Professional training",
            "Formation professionelle"
    )
    val tc_train_content = e(
            "Asynchronous & multiplatform programming. Native compilation. Migration to modern Kotlin.",
            "Programmation asynchrone & multi-platformes. Compilation native. Migration au Kotlin moderne."
    )

    val tc_work_title = e(
            "KotlinConf Workshop",
            "Workshop KotlinConf"
    )
    val tc_work_content = e(
            "Join us to the multiplatform KotlinConf 2019 workshop!",
            "Rejoignez-nous au Workshop sur le multi-plateformes à la KotlinConf 2019 !"
    )

    val tc_arch_title = e(
            "Architecture consultancy",
            "Consulting architecture"
    )
    val tc_arch_content = e(
            "Join us to the multiplatform KotlinConf 2019 workshop!",
            "Creation, documentation et deploiement d'architectures Open Source modernes."
    )

    val ke_title = e(
            "We deploy your business everywhere:",
            "Nous déployons votre business partout :"
    )

    val ke_subtitle = e(
            "All mobile & web platforms at once!",
            "Toutes les plateformes web et mobile d'un coup!"
    )

    val ke_code_title = e(
            { +"Code once," ; br {} ; +"test once," ; br {} ; +"run everywhere." },
            { +"Un code, une campagne de test," ; br {} ; +"toutes les plateformes." }
    )

    val ke_code_content = e(
            {
                +"Kotlin is the first industry language to be developped with multiplatform in mind."
                br {}
                +"This means that, rather than trying to squeeze an existing language and its unfitted runtime into another target, the language and its runtime has been thought from its very inception for multiplatform and portability."
                br {}
                +"Doing so, Kotlin elegantly factorizes the common runtime capabilities while allowing programmers to be specific about each targetted platform."
            },
            {
                +"Kotlin est le premier langage industriel à avoir été développé pour le multi-platformes."
                br {}
                +"Celà signifie que, plutôt que d'essayer d'adapter un language existant sa runtime non adapté à une autre plateforme, ce langage et sa runtime ont été pensés dès leur conception pour le multi-plateformes et la portabilité."
                br {}
                +"Ainsi, Kotlin factorise de manière élegante les fonctionnalités communes des runtimes, tout en permettant au programmeur d'être sépcifique sur chaque plateforme ciblée."
            }
    )

    val ke_kodein_title = e(
            { +"Kodein Koders is at the center of Kotlin/Everywhere in Europe." },
            { +"Kodein Koders est le point d'orgue de Kotlin/Everywhere en Europe." }
    )

    val ke_kodein_content = e(
            {
                +"We released the first non-Jetbrains library to be multiplatform and usable on each and every platform Kotlin can target."
                br {}
                +"By partnering closely with JetBrains (the creators of Kotlin), we ensure that we are always on top of each evolution of the language."
                br {}
                +"Kodein Koders is the first training provider in Europe focused on Kotlin/Everywhere technologies. We provided industry recognized training on multiplatform, asychronous & native Kotlin development."
            },
            {
                +"Nous avons publié la première librairie multi-platformes non-Jetbrains utilisable sur chacune des platformes que Kotlin peut cibler."
                br {}
                +"Parceque nous somees partenaires JetBrains (créateur de Kotlin), nous nous assurons d'être à la pointe de chaque évolution du langage."
                br {}
                +"Kodein Koders est le premier fournisseur de formation en Europe focalisé sur les technologies Kotlin/Everywhere. Nous fournissons des formations reconnues par l'industrie sur le développement Kotlin multi-platformes, asychrone & natif."
            }
    )

    val ke_open_title = e(
            { +"Open Source is a way of code:" ; br {} ; +"using is only the first step." },
            { +"L'Open source est un état d'esprit :" ; br {} ; +"l'utiliser n'est que le premier pas." }
    )

    val ke_open_content = e(
            {
                +"The Kodein Framework is the first Open-Source multiplatform mobile framework written specifically for Kotlin & Kotlin/Everywhere. It allows programmers to focus on their application business."
                br {}
                +"We firmly believe that open sourcing non-business critical components and contributing to existing projects leads to better software."
                br {}
                +"Kodein Koders is heavily invested in using "; b { +"and contributing" } ; +" to Open Source initiatives. The Kotlin language & runtine as well as the Kodein Framework: everything is Open!"
            },
            {
                +"Le Kodein Framework est le premier framework mobile multi-plateformes Open-Source écrit spécifiquement pour Kotlin & Kotlin/Everywhere. Il permet au programmeur de se focaliser sur le métier de son application."
                br {}
                +"Nous croyons profondément qu'Open-Sourcer des composants métiers non critiques et contribuer à des projets existants mène à de meilleurs logiciels."
                br {}
                +"Kodein Koders est fortement investi dans l'utilisation "; b { +"et la contribution" } ; +" à plusieurs initiatives Open Source. Le langage Kotlin et sa runtine ainsi que le Kodein Framework: tout est Open!"
            }
    )

    val os_multi_title = e(
            "Multiplatform",
            "Multi-platformes"
    )

    val os_multi_content = e(
            "First application Kotlin multiplatform framework.",
            "Premier framework multi-plateformes applicatif Kotlin."
    )

    val os_mobile_title = e(
            "Mobile first",
            "Mobile first"
    )

    val os_mobile_content = e(
            "Made with Android, iOS & the mobile Web in mind.",
            "Pensé avec Android, iOS & le Web mobile en tête."
    )

    val os_open_title = e(
            "Open Source",
            "Open Source"
    )

    val os_open_content = e(
            "Safe, documented, thoroughly tested and widely used.",
            "Sécurisé, documenté, minutieusement testé et largement utilisé."
    )

    val os_evw_title = e(
            "Everywhere",
            "Partout"
    )

    val os_evw_content = e(
            "Safe, documented, thoroughly tested and widely used.",
            "Compatible avec les plateformes mobiles, servers, bureaux & embarquées."
    )

    val os_years = e(
            "years!",
            "ans !"
    )

    val os_text_1 = e(
            {
                +"For business code units, using the Kotlin language & the Kodein framework unlocks an amazing potential: the ability to truly develop once, test once and deploy everywhere."
                br {}
                +"In addition to JVM and Android bytecode, Kotlin & Kodein can target Javascript as well as native iOS assembly."
            },
            {
                +"Pour les unités de code métier, utiliser le langage Kotlin et le framework Kodein débloque un potentiel incroyable : la capacité de ne réellement développer qu'une seule fois, et de déployer partout."
                br {}
                +"En plus des bytecodes JVM et Android, Kotlin & Kodein peuvent cibler Javascript ainsi que l'assembleur natif iOS."
            }
    )

    val os_text_2 = e(
            {
                b { +"KODEIN" }
                +"Koders is at the root of the #1 multi-platform framework that allows a developer to create business code units that can run on Android, iOS, the Web, server and desktop softwares."
            },
            {
                b { +"KODEIN" }
                +"Koders est à l'origine du framework multi-platformes n°1 permettant au développeur de créer des unités de code métiers qui peuvent être exécutées sur Android, iOS, le Web, les serveurs, et les logiciels de bureau."
            }
    )

    val os_text_3 = e(
            {
                +"Want to know more? Get trained to this amazing techn? "
                b { +"Contact us!" }
            },
            {
                +"Envie d'en savoir plus ? D'être formé à cette super techno ? "
                b { +"Contactez nous !" }
            }
    )

    val ct_title = e(
            "Contact & Community",
            "Contact & Communauté"
    )

    val ct_contact = e(
            "Contact",
            "Contact"
    )

    val ct_open = e(
            "Open Source",
            "Open Source"
    )

    val ct_job_title = e(
            "Jobs",
            "Jobs"
    )

    val ct_job_allin = e(
            "All in on Kotlin?",
            "Tapis sur Kotlin ?"
    )

    val ct_job_join = e(
            "join us!",
            "rejoignez-nous !"
    )
}
