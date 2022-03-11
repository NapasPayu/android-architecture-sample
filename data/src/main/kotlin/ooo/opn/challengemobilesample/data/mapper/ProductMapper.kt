package ooo.opn.challengemobilesample.data.mapper

import ooo.opn.challengemobilesample.data.model.ProductEntity
import ooo.opn.challengemobilesample.domain.model.Product

class ProductMapper : Mapper<ProductEntity, Product> {
    override fun mapFromEntity(entity: ProductEntity): Product {
        return with(entity) {
            Product(
                imageUrl = imageUrl ?: "",
                name = name ?: "",
                price = price ?: 0
            )
        }
    }
}