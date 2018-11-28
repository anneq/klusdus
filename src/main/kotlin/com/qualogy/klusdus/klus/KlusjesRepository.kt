package com.qualogy.klusdus.klus

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
interface KlusjesRepository: MongoRepository<Klusje, String> {
    fun findByGedaanFalse(): List<Klusje>
}