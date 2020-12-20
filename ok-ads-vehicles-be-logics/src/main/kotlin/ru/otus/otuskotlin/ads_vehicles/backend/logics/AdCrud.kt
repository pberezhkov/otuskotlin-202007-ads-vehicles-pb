package ru.otus.otuskotlin.ads_vehicles.backend.logics

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository

class AdCrud(
        private val adRepository: IAdRepository,
        private val makeCrud: MakeCrud,
        private val modelCrud: ModelCrud,
        private val generationCrud: GenerationCrud,
        private val equipmentCrud: EquipmentCrud
) {

}