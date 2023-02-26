package com.github.flexicon.mazes

class Grid(
    private val rows: Int,
    private val columns: Int,
) {
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

    operator fun get(row: Int, column: Int): Cell? {
        if (row >= rows) return null
        if (row < 0) return null
        if (column >= grid[row].size) return null
        if (column < 0) return null

        return grid[row][column]
    }

    fun forEachCell(fn: (Cell) -> Unit) = forEachRow { it.forEach(fn) }

    private fun forEachRow(fn: (List<Cell>) -> Unit) = grid.forEach { fn(it) }
}