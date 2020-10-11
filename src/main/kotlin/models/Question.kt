package models

data class Question(
    val DisplayParameters: String = "",
    val Id: String = "",
    val Name: Any? = Any(),
    val QuestionGlobalIdentifier: String = "",
    val QuestionContent: List<QuestionContent> = listOf(),
    val PureQuestionText: String = "",
    val IsRequired: Boolean = false,
    val QuestionType: String = "",
    val MinValueLabel: List<MinValueLabel> = listOf(),
    val MaxValueLabel: List<MaxValueLabel> = listOf(),
    val Order: Int = 0,
    val SqlDataType: Any? = Any(),
    val QuestionOptions: List<QuestionOption> = listOf(),
    val QuestionHint: List<Any> = listOf(),
    val Configurations: List<Configuration> = listOf()
)