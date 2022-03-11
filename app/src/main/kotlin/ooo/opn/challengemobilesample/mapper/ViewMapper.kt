package ooo.opn.challengemobilesample.mapper

interface ViewMapper<D, V> {
    fun mapToView(type: D): V
}