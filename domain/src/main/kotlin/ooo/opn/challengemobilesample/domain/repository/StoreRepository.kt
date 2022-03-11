package ooo.opn.challengemobilesample.domain.repository

import ooo.opn.challengemobilesample.domain.model.Store

interface StoreRepository {
    suspend fun getStoreInfo(): Result<Store>
}