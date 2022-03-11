package ooo.opn.challengemobilesample.data.repository

import ooo.opn.challengemobilesample.data.mapper.StoreMapper
import ooo.opn.challengemobilesample.data.remote.StoreInfoService
import ooo.opn.challengemobilesample.domain.model.Store
import ooo.opn.challengemobilesample.domain.repository.StoreRepository

class StoreRepositoryImpl(
    private val storeInfoService: StoreInfoService,
    private val storeMapper: StoreMapper
) : StoreRepository {
    override suspend fun getStoreInfo(): Result<Store> {
        return runCatching {
            storeMapper.mapFromEntity(storeInfoService.getStoreInfo())
        }
    }
}