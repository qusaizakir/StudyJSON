package views

import javafx.beans.property.SimpleStringProperty
import logic.createObjectsFromJSON
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
                    createObjectsFromJSON(jsonInput.get())
                } ui {success ->
                    if(success) information("Successfully created Questionnaire.kt")
                }

            }
        }

    }
}