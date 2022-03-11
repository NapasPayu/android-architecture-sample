package ooo.opn.challengemobilesample.domain.di

import ooo.opn.challengemobilesample.domain.usecase.GetProductsUseCase
import ooo.opn.challengemobilesample.domain.usecase.GetStoreUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetStoreUseCase(get()) }
    single { GetProductsUseCase(get()) }
}