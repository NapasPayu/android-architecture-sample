package ooo.opn.challengemobilesample.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(entity: E): D
}