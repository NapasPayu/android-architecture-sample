package ooo.opn.challengemobilesample.domain.usecase

import ooo.opn.challengemobilesample.domain.repository.ProductRepository

class GetProductsUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke() = productRepository.getProducts()
}