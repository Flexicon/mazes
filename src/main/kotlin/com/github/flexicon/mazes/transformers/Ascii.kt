package com.github.flexicon.mazes.transformers

import com.github.flexicon.mazes.Grid

private const val V_WALL = "|"
private const val V_GAP = " "
private const val H_WALL = "---"
private const val H_GAP = "   "
private const val CORNER = "+"

fun Grid.toAscii() = buildString {
    append("$CORNER${"$H_WALL$CORNER".repeat(columns)}\n")

    forEachRow { row ->
        var mid = V_WALL
        var bot = CORNER

        row.forEach { cell ->
            mid += H_GAP + if (cell.isLinked(cell.east)) {
                V_GAP
            } else {
                V_WALL
            }

            bot += if (cell.isLinked(cell.south)) {
                H_GAP
            } else {
                H_WALL
            } + CORNER
        }

        append("$mid\n$bot\n")
    }
}.trim()
