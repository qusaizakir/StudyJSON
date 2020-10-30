package views

import javafx.beans.property.SimpleStringProperty
import logic.createEventsFromJSON
import logic.createQuestionnairesFromJSON
import tornadofx.*

class MainView: View("ERT Study JSON") {

    private val jsonInput = SimpleStringProperty("")

    override val root = vbox {

        addClass(Styles.mainVBox)

        label(title){
            addClass(Styles.title)
        }

        textfield(jsonInput){
            addClass(Styles.JSONInput)
        }

        button("Create Questionnaire.kt"){
            addClass(Styles.createButton)
            action {
                runAsyncWithProgress {
                    createQuestionnairesFromJSON(jsonInput.get())
                } ui {success ->
                    if(success) information("Successfully created Questionnaire.kt")
                }

            }
        }

        button("Create Events.kt"){
            addClass(Styles.createButton)
            action {
                runAsyncWithProgress {
                    createEventsFromJSON(jsonInput.get())
                } ui {success ->
                    if(success) information("Successfully created Events.kt")
                }

            }
        }

    }
}