package ooo.opn.challengemobilesample.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ooo.opn.challengemobilesample.base.BaseFragment
import ooo.opn.challengemobilesample.store.adapter.ProductListAdapter
import ooo.opn.challengemobilesample.store.adapter.StoreDetailAdapter
import ooo.opn.challengemobilesample.store.databinding.FragmentStoreBinding
import ooo.opn.challengemobilesample.store.di.storeModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class StoreFragment : BaseFragment() {
    private lateinit var binding: FragmentStoreBinding
    private val viewModel: StoreViewModel by viewModel()
    private val headerAdapter by lazy { StoreDetailAdapter() }
    private val listAdapter by lazy { ProductListAdapter() }
    private val concatAdapter by lazy { ConcatAdapter(headerAdapter, listAdapter) }

    init {
        loadKoinModules(storeModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = concatAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(StoreFragmentDirections.storeToOrdersuccess())
        }

        viewModel.alertEvent.observe(viewLifecycleOwner) {
            it?.let {
                showAlert(it)
            }
        }
        viewModel.store.observe(viewLifecycleOwner) {
            it?.let {
                headerAdapter.submitList(listOf(it))
            }
        }
        viewModel.products.observe(viewLifecycleOwner) {
            it?.let {
                listAdapter.submitList(it)
            }
        }
    }
}