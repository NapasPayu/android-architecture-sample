package ooo.opn.challengemobilesample.domain.repository

import ooo.opn.challengemobilesample.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>>
}