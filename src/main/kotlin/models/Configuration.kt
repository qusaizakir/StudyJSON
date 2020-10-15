package models

import com.beust.klaxon.Json

data class Configuration(
    val Id: String = "",
    val GeneralSettings: GeneralSettings = GeneralSettings(),
    val MeasurementSettings: Any? = Any(),
    val DateTimeSettings: Any? = Any(),
    @Json(ignored = true)
    val TriggeredMessages: List<Any> = emptyList()
)