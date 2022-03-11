package ooo.opn.challengemobilesample.store.mapper

import ooo.opn.challengemobilesample.domain.model.Store
import ooo.opn.challengemobilesample.mapper.ViewMapper
import ooo.opn.challengemobilesample.store.model.StoreView

class StoreViewMapper : ViewMapper<Store, StoreView> {
    override fun mapToView(type: Store): StoreView {
        return with(type) {
            StoreView(
                name = name,
                rating = rating.toFloat(),
                openingHours = "$openingTime - $closingTime"
            )
        }
    }
}