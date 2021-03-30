package com.igorwojda.showcase.feature.explore.presentation

import androidx.fragment.app.Fragment
import coil.ImageLoader
import com.igorwojda.showcase.feature.explore.MODULE_NAME
import com.igorwojda.showcase.feature.explore.presentation.explorelist.ExploreListViewModel
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.ExploreAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.InspireAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.LatestReleaseAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.NearbyAdapter
import com.igorwojda.showcase.library.base.di.KotlinViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    // AlbumList
    bind<ExploreListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { ExploreListViewModel(instance()) }
    }

    bind() from singleton { ExploreAdapter() }
    bind() from singleton { LatestReleaseAdapter() }
    bind() from singleton { InspireAdapter() }
//    bind() from singleton { ImageLoader(instance()) }
}
