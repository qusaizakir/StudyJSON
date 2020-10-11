package models

data class Condition(
    val Id: String = "",
    val BranchId: String = "",
    val QuestionId: String = "",
    val StampedQuestionText: String = "",
    val IsORCondition: Boolean = false,
    val Evaluations: List<Evaluation> = listOf()
)