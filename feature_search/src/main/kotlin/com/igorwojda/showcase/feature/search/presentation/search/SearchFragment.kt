package com.igorwojda.showcase.feature.search.presentation.search

import android.os.Bundle
import android.view.View
import com.igorwojda.showcase.feature.search.R
import com.igorwojda.showcase.feature.search.utils.SampleSearchModel
import com.igorwojda.showcase.library.base.presentation.fragment.InjectionFragment
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat
import ir.mirrajabi.searchdialog.core.SearchResultListener
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*


class SearchFragment : InjectionFragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_novel_list.setOnClickListener {
            var list = mutableListOf<SampleSearchModel>()
            Arrays.asList(resources.getStringArray(R.array.novel_type))[0].toList().forEach {
                list.add(SampleSearchModel(it))
            }

            SimpleSearchDialogCompat(activity, "Search...","Search...", null,
                list as ArrayList<SampleSearchModel?>,
            object : SearchResultListener<SampleSearchModel?> {
                override fun onSelected(dialog: BaseSearchDialogCompat<*>?, item: SampleSearchModel?, position: Int) {
                    btn_novel_list.text = item!!.title
                    dialog!!.dismiss()
                }
            }).show()
        }

        btn_genre.setOnClickListener {
            var list = mutableListOf<SampleSearchModel>()
            Arrays.asList(resources.getStringArray(R.array.genre_type))[0].toList().forEach {
                list.add(SampleSearchModel(it))
            }

            SimpleSearchDialogCompat(activity, "Search...","Search...", null,
                list as ArrayList<SampleSearchModel?>,
                object : SearchResultListener<SampleSearchModel?> {
                    override fun onSelected(dialog: BaseSearchDialogCompat<*>?, item: SampleSearchModel?, position: Int) {
                        btn_genre.text = item!!.title
                        dialog!!.dismiss()
                    }
                }).show()
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
