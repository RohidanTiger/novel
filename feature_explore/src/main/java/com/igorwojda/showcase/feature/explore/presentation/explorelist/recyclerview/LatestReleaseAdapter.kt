package com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.igorwojda.showcase.feature.explore.R
import com.igorwojda.showcase.feature.explore.domain.model.ExploreDomainModel
import com.igorwojda.showcase.library.base.delegate.observer
import kotlinx.android.synthetic.main.item_latest_release.view.*

internal class LatestReleaseAdapter : RecyclerView.Adapter<LatestReleaseAdapter.MyViewHolder>() {

    var albums: List<ExploreDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_latest_release, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(albums[position])
        holder.itemView.tv_nearby_name.text = albums[position].name
    }

    override fun getItemCount(): Int = albums.size

    internal inner class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var url by observer<String?>(null) {
        }

        fun bind(albumDomainModel: ExploreDomainModel) {
            url = albumDomainModel.getDefaultImageUrl()
        }
    }
}
