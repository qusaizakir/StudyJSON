package logic

import com.beust.klaxon.Klaxon
import logic.Constants.constVal
import logic.Constants.globalId
import logic.Constants.objectSt
import models.Question
import models.Questionnaire
import models.Study
import tornadofx.runLater
import tornadofx.warning
import java.io.File

const val englishLangID = "132872f9-9d43-4c59-98a8-568c3359317e"

object Constants {
    const val objectSt = "object"
    const val constVal = "const val"
    const val globalId = "globalId"
}


fun createObjectsFromJSON(json: String): Boolean {
    var study: Study? = null
    try {
        study = Klaxon().parse<Study>(json)
    }catch (e: Exception){
        runLater {
            warning("Not valid study JSON")
        }
    }

    study?.apply {
        File("Questionnaires.kt").writeText(createQuestionnaireContent(this))
        return true
    }
    return false
}

fun createQuestionnaireContent(study: Study): String {

    val stringBuilder = StringBuilder()
    study.Questionnaires.forEach {questionnaire ->

        val name = (questionnaire.Name.find { it.LanguageId == englishLangID}?.Content ?: "noEnglishName").toString().toCamelCase()
        val globalID = questionnaire.QuestionnaireGlobalIdentifier

        val string =
            """$objectSt $name {
                |   $constVal $globalId = "$globalID"
            """.trimMargin()

        stringBuilder.append(string)
        addQuestionsToString(questionnaire, stringBuilder)
        stringBuilder.newLine()
        stringBuilder.append("}")
        stringBuilder.newLine()
        stringBuilder.newLine()
    }

    return stringBuilder.toString()
}

fun addQuestionsToString(questionnaire: Questionnaire, stringBuilder: StringBuilder) {

    questionnaire.Flows.forEach { flow ->
        flow.FlowSteps.forEach { flowSteps ->
            val questions = flowSteps.Page.Questions
            val pageName = flowSteps.Page.Name
            stringBuilder.newLine()
            stringBuilder.append("""    //$pageName""")
            questions.forEach {question ->
                val questionName = (question.Name ?: "noEnglishName").toString().toCamelCase()
                val questionGlobalId = question.QuestionGlobalIdentifier

                stringBuilder.newLine()
                val questionString =
                    """    $constVal $questionName = "$questionGlobalId""""

                stringBuilder.append(questionString)
            }
        }
    }

}