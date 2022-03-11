package ooo.opn.challengemobilesample.store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ooo.opn.challengemobilesample.store.databinding.ItemProductBinding
import ooo.opn.challengemobilesample.store.model.ProductView

class ProductListAdapter :
    ListAdapter<ProductView, ProductListAdapter.ViewHolder>(ProductDiffCallback) {

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductView) {
            binding.product = product
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object ProductDiffCallback : DiffUtil.ItemCallback<ProductView>() {
    override fun areItemsTheSame(oldItem: ProductView, newItem: ProductView): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ProductView, newItem: ProductView): Boolean {
        return oldItem == newItem
    }
}