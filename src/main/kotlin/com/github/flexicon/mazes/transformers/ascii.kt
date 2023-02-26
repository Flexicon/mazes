package com.github.flexicon.mazes.transformers

import com.github.flexicon.mazes.Grid

// TODO: refactor from direct ruby translation to more idiomatic kotlin
fun Grid.toAscii(): String {
    var output = "+${"---+".repeat(columns)}\n"

    forEachRow { row ->
        var mid = "|"
        var bot = "+"

        row.forEach { cell ->
            mid += "   " + if (cell.isLinked(cell.east)) {
                " "
            } else {
                "|"
            }

            bot += if (cell.isLinked(cell.south)) {
                "   "
            } else {
                "---"
            } + "+"
        }

        output += "$mid\n$bot\n"
    }

    return output.trim()
}
