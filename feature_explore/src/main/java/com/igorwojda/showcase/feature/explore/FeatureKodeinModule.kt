package com.igorwojda.showcase.feature.explore

import com.igorwojda.showcase.app.feature.KodeinModuleProvider
import com.igorwojda.showcase.feature.explore.data.dataModule
import com.igorwojda.showcase.feature.explore.domain.domainModule
import com.igorwojda.showcase.feature.explore.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Explore"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
