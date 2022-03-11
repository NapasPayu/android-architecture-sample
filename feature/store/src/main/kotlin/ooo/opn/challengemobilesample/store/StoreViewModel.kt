package ooo.opn.challengemobilesample.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ooo.opn.challengemobilesample.base.BaseViewModel
import ooo.opn.challengemobilesample.domain.usecase.GetProductsUseCase
import ooo.opn.challengemobilesample.domain.usecase.GetStoreUseCase
import ooo.opn.challengemobilesample.store.mapper.ProductViewMapper
import ooo.opn.challengemobilesample.store.mapper.StoreViewMapper
import ooo.opn.challengemobilesample.store.model.ProductView
import ooo.opn.challengemobilesample.store.model.StoreView

class StoreViewModel(
    private val getStoreUseCase: GetStoreUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val storeViewMapper: StoreViewMapper,
    private val productViewMapper: ProductViewMapper
) : BaseViewModel() {

    val store = MutableLiveData<StoreView>()
    val products = MutableLiveData<List<ProductView>>()

    init {
        showLoading()
        viewModelScope.launch {
            val storeDeferred = async { getStoreUseCase() }
            val productsDeferred = async { getProductsUseCase() }
            val storeResult = storeDeferred.await()
            val productsResult = productsDeferred.await()
            if (storeResult.isSuccess && productsResult.isSuccess) {
                store.value = storeViewMapper.mapToView(storeResult.getOrThrow())
                products.value = productsResult.getOrThrow().map(productViewMapper::mapToView)
            } else {
                alert(
                    message = listOfNotNull(
                        storeResult.exceptionOrNull()?.message,
                        productsResult.exceptionOrNull()?.message
                    ).joinToString()
                )
            }
            hideLoading()
        }
    }
}