package ooo.opn.challengemobilesample.data.remote

import ooo.opn.challengemobilesample.data.model.StoreEntity
import retrofit2.http.GET

interface StoreInfoService {
    @GET("storeInfo")
    suspend fun getStoreInfo(): StoreEntity
}