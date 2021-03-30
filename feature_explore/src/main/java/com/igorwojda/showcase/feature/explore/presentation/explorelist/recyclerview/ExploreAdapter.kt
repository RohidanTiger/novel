package com.igorwojda.showcase.feature.explore.presentation.explorelist.recyclerview

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.igorwojda.showcase.feature.explore.R
import com.igorwojda.showcase.feature.explore.domain.model.ExploreDomainModel
import com.igorwojda.showcase.library.base.delegate.observer
import kotlinx.android.synthetic.main.fragment_explore_list_item.view.*

internal class ExploreAdapter : RecyclerView.Adapter<ExploreAdapter.MyViewHolder>() {

    var albums: List<ExploreDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private val startItemCount: Int = 0
    private val endItemCount: Int = 8

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_explore_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(albums[position])
        var names = albums[position].name.split("")
        var exploreName = ""
        for (item: Int in startItemCount..endItemCount) {
            exploreName += names[item]
        }
        exploreName += "..."
        holder.itemView.tv_name.text = exploreName
    }

    override fun getItemCount(): Int = albums.size

    internal inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var url by observer<String?>(null) {
            itemView.iv_explore_item.load(it) {
                crossfade(true)
                error(R.drawable.ic_image)
                transformations(RoundedCornersTransformation(10F))
            }
        }

        fun bind(albumDomainModel: ExploreDomainModel) {
            url = albumDomainModel.getDefaultImageUrl()
        }
    }
}
