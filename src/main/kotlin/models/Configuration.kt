package models

data class Configuration(
    val Id: String = "",
    val GeneralSettings: GeneralSettings = GeneralSettings(),
    val MeasurementSettings: Any? = Any(),
    val DateTimeSettings: Any? = Any(),
    val TriggeredMessages: List<Any> = listOf()
)