package models

data class Questionnaire(
    val Id: String = "",
    val Description: String = "",
    val QuestionnaireGlobalIdentifier: String = "",
    val Name: List<Name> = listOf(),
    val Version: String = "",
    val Flows: List<Flow> = listOf(),
    val IsSuccessful: Boolean = false,
    val IsUsedForTraining: Boolean = false,
    val LanguageIds: Any? = Any()
)