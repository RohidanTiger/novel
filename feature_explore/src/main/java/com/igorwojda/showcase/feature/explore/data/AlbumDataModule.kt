package com.igorwojda.showcase.feature.explore.data

import com.igorwojda.showcase.feature.explore.data.repository.ExploreRepositoryImpl
import com.igorwojda.showcase.feature.explore.data.retrofit.service.ExploreRetrofitService
import com.igorwojda.showcase.feature.explore.domain.repository.ExploreRepository
import com.igorwojda.showcase.feature.explore.MODULE_NAME
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind<ExploreRepository>() with singleton { ExploreRepositoryImpl(instance()) }

    bind() from singleton { instance<Retrofit>().create(ExploreRetrofitService::class.java) }
}
