package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Cell
import com.github.flexicon.mazes.Grid
import kotlin.random.Random

class Sidewinder internal constructor(private val rand: Random = Random) : Algorithm {
    override fun applyTo(grid: Grid) {
        grid.forEachRow { row ->
            val cellsRun = mutableListOf<Cell>()

            row.forEach { cell ->
                cellsRun.add(cell)

                if (shouldCloseOutRun(cell)) {
                    cellsRun.apply {
                        random(rand).apply { north?.link(this) }
                        clear()
                    }
                } else {
                    cell.east?.let { cell.link(it) }
                }
            }
        }
    }

    private fun shouldCloseOutRun(cell: Cell): Boolean =
        cell.east == null || (cell.north != null && rand.nextBoolean())

    companion object : Algorithm by Sidewinder()
}
