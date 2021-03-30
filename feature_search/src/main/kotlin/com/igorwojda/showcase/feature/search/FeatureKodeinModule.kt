package com.igorwojda.showcase.feature.search

import com.igorwojda.showcase.app.feature.KodeinModuleProvider
import com.igorwojda.showcase.feature.search.data.dataModule
import com.igorwojda.showcase.feature.search.domain.domainModule
import com.igorwojda.showcase.feature.search.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Search"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
