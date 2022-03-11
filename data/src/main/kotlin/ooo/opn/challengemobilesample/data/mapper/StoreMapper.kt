package ooo.opn.challengemobilesample.data.mapper

import ooo.opn.challengemobilesample.data.model.StoreEntity
import ooo.opn.challengemobilesample.domain.model.Store

class StoreMapper : Mapper<StoreEntity, Store> {
    override fun mapFromEntity(entity: StoreEntity): Store {
        return with(entity) {
            Store(
                closingTime = closingTime ?: "",
                name = name ?: "",
                openingTime = openingTime ?: "",
                rating = rating ?: 0.0
            )
        }
    }
}