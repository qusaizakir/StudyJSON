package models

data class QuestionOption(
    val Id: String = "",
    val Rank: Int = 0,
    val QuestionOptionGlobalIdentifier: String = "",
    val OptionText: List<OptionText> = listOf(),
    val Value: String = ""
)