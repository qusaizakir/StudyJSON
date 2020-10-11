package models

data class JourneyGroup(
    val Id: String = "",
    val Journeys: List<Journey> = listOf(),
    val Name: String = "",
    val NameTranslations: List<NameTranslationX> = listOf()
)