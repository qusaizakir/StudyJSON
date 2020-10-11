package logic

fun String.toCamelCase(): String {

    return split(" ").joinToString(" ") { it.capitalize() }
        .replace(" ", "")
        .replace("'", "")
}

fun StringBuilder.newLine(){
    append(System.getProperty("line.separator"))
}