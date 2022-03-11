package ooo.opn.challengemobilesample.data.repository

import ooo.opn.challengemobilesample.data.mapper.ProductMapper
import ooo.opn.challengemobilesample.data.remote.ProductService
import ooo.opn.challengemobilesample.domain.model.Product
import ooo.opn.challengemobilesample.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productService: ProductService,
    private val productMapper: ProductMapper
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        return runCatching {
            productService.getProducts().map(productMapper::mapFromEntity)
        }
    }
}