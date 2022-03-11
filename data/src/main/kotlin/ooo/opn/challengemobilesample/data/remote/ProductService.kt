package ooo.opn.challengemobilesample.data.remote

import ooo.opn.challengemobilesample.data.model.ProductEntity
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<ProductEntity>
}