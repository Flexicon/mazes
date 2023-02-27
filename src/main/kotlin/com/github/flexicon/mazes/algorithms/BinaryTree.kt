package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Grid
import kotlin.random.Random

class BinaryTree internal constructor(private val rand: Random = Random) : Algorithm {
    override fun applyTo(grid: Grid) {
        grid.forEachCell { cell ->
            val neighbors = buildList {
                cell.north?.let { add(it) }
                cell.east?.let { add(it) }
            }

            neighbors.randomOrNull(rand)?.let { cell.link(it) }
        }
    }

    companion object : Algorithm by BinaryTree()
}
