package ooo.opn.challengemobilesample.data.di

import okhttp3.OkHttpClient
import ooo.opn.challengemobilesample.data.BuildConfig
import ooo.opn.challengemobilesample.data.mapper.ProductMapper
import ooo.opn.challengemobilesample.data.mapper.StoreMapper
import ooo.opn.challengemobilesample.data.remote.ProductService
import ooo.opn.challengemobilesample.data.remote.StoreInfoService
import ooo.opn.challengemobilesample.data.repository.ProductRepositoryImpl
import ooo.opn.challengemobilesample.data.repository.StoreRepositoryImpl
import ooo.opn.challengemobilesample.domain.repository.ProductRepository
import ooo.opn.challengemobilesample.domain.repository.StoreRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { StoreMapper() }
    single { ProductMapper() }

    single {
        Retrofit.Builder()
            .client(provideOkHttp())
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//            .apply {
//                create(StoreInfoService::class.java)
//                create(ProductService::class.java)
//            }
    }

    single { get<Retrofit>().create(StoreInfoService::class.java) }
    single { get<Retrofit>().create(ProductService::class.java) }

    single<StoreRepository> { StoreRepositoryImpl(get(), get()) }
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
}

fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder().build()