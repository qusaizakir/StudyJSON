package logic

import com.beust.klaxon.Klaxon
import logic.Constants.constVal
import logic.Constants.globalId
import logic.Constants.objectSt
import models.FlowStep
import models.Question
import models.Questionnaire
import models.Study
import models.events.Events
import tornadofx.runLater
import tornadofx.warning
import java.io.File

const val englishLangID = "132872f9-9d43-4c59-98a8-568c3359317e"

object Constants {
    const val objectSt = "object"
    const val constVal = "const val"
    const val globalId = "globalId"
    const val events = "Events"
}


fun createQuestionnairesFromJSON(json: String): Boolean {
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

fun createEventsFromJSON(json: String): Boolean {
    var events: Events? = null
    try {
        events = Klaxon().parse<Events>(json)
    }catch (e: Exception){
        runLater {
            warning("Not valid event JSON")
        }
    }

    events?.apply {
        File("Events.kt").writeText(createEventsContent(this))
        return true
    }
    return false
}

fun createEventsContent(events: Events): String {

    val stringBuilder = StringBuilder()

    val start = """$objectSt ${Constants.events} {"""

    stringBuilder.append(start)
    stringBuilder.newLine()

    events.Events.forEach {event ->

        val name = event.Name.toCamelCase()
        val globalID = event.EventGlobalIdentifier

        val string =
        """     $constVal $name = "$globalID"
        """.trimMargin()

        stringBuilder.append(string)
        stringBuilder.newLine()
    }

    stringBuilder.append("}")
    return stringBuilder.toString()

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
        flow.FlowSteps.sortedBy {it.Order}.forEach {flowSteps ->
            val questions = flowSteps.Page.Questions
            val pageName = flowSteps.Page.Name
            val pageNameID = flowSteps.Page.Name.toCamelCase()+"Page"
            val pageID = flowSteps.Page.PageGlobalIdentifier
            stringBuilder.newLine()
            stringBuilder.append("""    //$pageName""")
            stringBuilder.newLine()
            stringBuilder.append("""    $constVal $pageNameID = "$pageID"""")
            questions.forEach {question ->
                if(question.Name != null){
                    val questionName = (question.Name).toString().toCamelCase()
                    val questionGlobalId = question.QuestionGlobalIdentifier

                    stringBuilder.newLine()
                    val questionString =
                            """    $constVal $questionName = "$questionGlobalId""""

                    stringBuilder.append(questionString)
                }

            }
        }
    }

}