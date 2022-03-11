package ooo.opn.challengemobilesample.store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ooo.opn.challengemobilesample.store.databinding.ItemStoreDetailBinding
import ooo.opn.challengemobilesample.store.model.StoreView

class StoreDetailAdapter :
    ListAdapter<StoreView, StoreDetailAdapter.ViewHolder>(StoreDetailDiffCallback) {

    inner class ViewHolder(private val binding: ItemStoreDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(store: StoreView) {
            binding.store = store
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreDetailBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object StoreDetailDiffCallback : DiffUtil.ItemCallback<StoreView>() {
    override fun areItemsTheSame(oldItem: StoreView, newItem: StoreView): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: StoreView, newItem: StoreView): Boolean {
        return oldItem == newItem
    }
}