package app

import views.MainView
import javafx.stage.Stage
import tornadofx.*
import views.Styles

fun main(args: Array<String>) {
    launch<Application>(args)
}

class Application : App(MainView::class, Styles::class) {

    init {
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        with(stage){
            width = 500.0
            height = 500.0
        }
        super.start(stage)
    }

}