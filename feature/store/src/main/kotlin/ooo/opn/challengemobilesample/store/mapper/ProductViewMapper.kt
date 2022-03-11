package ooo.opn.challengemobilesample.store.mapper

import ooo.opn.challengemobilesample.domain.model.Product
import ooo.opn.challengemobilesample.mapper.ViewMapper
import ooo.opn.challengemobilesample.store.model.ProductView

class ProductViewMapper : ViewMapper<Product, ProductView> {
    override fun mapToView(type: Product): ProductView {
        return with(type) {
            ProductView(
                imageUrl = imageUrl,
                name = name,
                price = price
            )
        }
    }
}