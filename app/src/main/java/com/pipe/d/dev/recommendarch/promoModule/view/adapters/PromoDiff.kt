package com.pipe.d.dev.recommendarch.promoModule.view.adapters

import androidx.recyclerview.widget.DiffUtil
import com.pipe.d.dev.recommendarch.common.entities.Promo

class PromoDiff: DiffUtil.ItemCallback<Promo>() {
    override fun areItemsTheSame(oldItem: Promo, newItem: Promo) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Promo, newItem: Promo) = oldItem == newItem
}