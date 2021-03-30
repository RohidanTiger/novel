package com.igorwojda.showcase.feature.explore.presentation.explorelist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igorwojda.showcase.feature.explore.R
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.ExploreAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.InspireAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.LatestReleaseAdapter
import com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview.NearbyAdapter
import com.igorwojda.showcase.library.base.presentation.extension.observe
import com.igorwojda.showcase.library.base.presentation.fragment.InjectionFragment
import kotlinx.android.synthetic.main.fragment_explore_list.*
import org.kodein.di.generic.instance

class ExploreListFragment : InjectionFragment(R.layout.fragment_explore_list) {

    private val viewModel: ExploreListViewModel by instance()

    private val exploreAdapter: ExploreAdapter by instance()

    private val nearbyAdapter: NearbyAdapter by instance()

    private val latestReleaseAdapter: LatestReleaseAdapter by instance()

    private val inspireAdapter: InspireAdapter by instance()

    private val stateObserver = Observer<ExploreListViewModel.ViewState> {
        exploreAdapter.albums = it.albums
        //nearbyAdapter.albums = it.albums
        latestReleaseAdapter.albums = it.albums
        inspireAdapter.albums = it.albums

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRecyclerView()
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setRecyclerView() {
        val context = checkNotNull(context)
        rv_explore.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.HORIZONTAL,
                    false
                )
            adapter = exploreAdapter
        }

        rv_inspire.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.HORIZONTAL,
                    false
                )
            adapter = inspireAdapter
        }

        rv_nearby.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false
                )
            adapter = latestReleaseAdapter
        }
    }
}
