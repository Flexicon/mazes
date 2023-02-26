package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Cell
import com.github.flexicon.mazes.Grid
import org.junit.jupiter.api.Test
import kotlin.random.Random

class BinaryTreeTest {
    private val rand = Random(6389)

    @Test
    fun applyTo() {
        val grid = Grid(3, 3)
        BinaryTree(rand).applyTo(grid)

        assert(grid[0, 0].isLinked(grid[0, 1]))
        assert(grid[0, 1].isLinked(grid[0, 2]))

        assert(grid[1, 0].isLinked(grid[1, 1]))
        assert(grid[1, 1].isLinked(grid[0, 1]))
        assert(grid[1, 2].isLinked(grid[0, 2]))

        assert(grid[2, 0].isLinked(grid[2, 1]))
        assert(grid[2, 1].isLinked(grid[2, 2]))
        assert(grid[2, 2].isLinked(grid[1, 2]))
    }

    private fun Cell?.isLinked(other: Cell?) =
        this?.isLinked(other) ?: false
}