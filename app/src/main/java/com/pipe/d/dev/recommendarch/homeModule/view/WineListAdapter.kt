package com.pipe.d.dev.recommendarch.homeModule.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pipe.d.dev.recommendarch.BR
import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.utils.OnClickListener
import com.pipe.d.dev.recommendarch.databinding.ItemWineBinding

/****
 * Project: Wines
 * From: com.cursosant.wines
 * Created by Alain Nicolás Tello on 06/02/24 at 20:23
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
open class WineListAdapter(private val listener: OnClickListener, diff: WineDiff) :
    ListAdapter<Wine, RecyclerView.ViewHolder>(diff) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_wine, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val wine = getItem(position)
        (holder as ViewHolder).run {
            setListener(wine)
            binding?.setVariable(BR.wine, wine)
            binding?.executePendingBindings()
        }
    }

    /*fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }*/

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemWineBinding>(view)

        fun setListener(wine: Wine) {
            binding?.root?.setOnLongClickListener {
                listener.onLongClick(wine)
                true
            }
            binding?.cbFavorite?.setOnClickListener {
                listener.onFavorite(wine)
            }
        }
    }
}