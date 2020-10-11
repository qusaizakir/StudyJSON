package views

import javafx.geometry.Pos
import tornadofx.*

class Styles : Stylesheet(){
    companion object {
        val title by cssclass()
        val mainVBox by cssclass()
        val JSONInput by cssclass()
        val createButton by cssclass()

        val standardPadding = 10.px
        val standardPaddingBox = box(standardPadding)
        val standardFontSize = 20.px
    }

    init {

        mainVBox {
            alignment = Pos.TOP_CENTER
            padding = box(30.px)
        }

        title {
            fontSize = standardFontSize
            textFill = c("blue", 1.0)
            padding = standardPaddingBox
        }

        JSONInput {
            maxHeight = 250.px
            maxWidth = 350.px
            minHeight = 250.px
            minWidth = 350.px
            padding = standardPaddingBox
        }

        createButton {
            padding = box(standardPadding * 2)
            borderInsets = multi(standardPaddingBox)
            backgroundInsets = multi(standardPaddingBox)
        }
    }
}