package com.github.flexicon.mazes

class Grid(val rows: Int, val columns: Int) {
    private val grid = List(rows) { row ->
        List(columns) { column ->
            Cell(row, column)
        }
    }

    init {
        forEachCell { cell ->
            val row = cell.row
            val col = cell.column

            cell.north = this[row - 1, col]
            cell.south = this[row + 1, col]
            cell.west = this[row, col - 1]
            cell.east = this[row, col + 1]
        }
    }

    operator fun get(row: Int, column: Int): Cell? =
        grid.getOrNull(row)?.getOrNull(column)

    fun forEachCell(fn: (Cell) -> Unit) = forEachRow { it.forEach(fn) }

    fun forEachRow(fn: (List<Cell>) -> Unit) = grid.forEach { fn(it) }
}