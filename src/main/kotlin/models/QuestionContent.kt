package models

data class QuestionContent(
    val Id: String = "",
    val TranslationId: String = "",
    val Content: String = "",
    val TranslationContentState: String = "",
    val LanguageId: String = "",
    val IsPrimary: Boolean = false,
    val State: Int = 0
)