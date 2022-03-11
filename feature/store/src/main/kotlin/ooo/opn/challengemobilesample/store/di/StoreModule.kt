package ooo.opn.challengemobilesample.store.di

import ooo.opn.challengemobilesample.store.StoreViewModel
import ooo.opn.challengemobilesample.store.mapper.ProductViewMapper
import ooo.opn.challengemobilesample.store.mapper.StoreViewMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val storeModule = module {
    single { StoreViewMapper() }
    single { ProductViewMapper() }
    viewModel { StoreViewModel(get(), get(), get(), get()) }
}