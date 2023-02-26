package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Grid

object BinaryTree : Algorithm {
    override fun applyTo(grid: Grid) {
        grid.forEachCell { cell ->
            val neighbors = buildList {
                cell.north?.let { add(cell) }
                cell.east?.let { add(cell) }
            }

            neighbors.randomOrNull()?.let { cell.link(it) }
        }
    }
}
