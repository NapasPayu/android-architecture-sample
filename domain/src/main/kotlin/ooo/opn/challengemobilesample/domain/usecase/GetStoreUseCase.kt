package ooo.opn.challengemobilesample.domain.usecase

import ooo.opn.challengemobilesample.domain.repository.StoreRepository

class GetStoreUseCase(private val storeRepository: StoreRepository) {
    suspend operator fun invoke() = storeRepository.getStoreInfo()
}