package com.github.flexicon.mazes

import com.github.flexicon.mazes.algorithms.Algorithm
import com.github.flexicon.mazes.algorithms.BinaryTree
import com.github.flexicon.mazes.algorithms.Sidewinder

object Maze {
    fun binaryTree(rows: Int, columns: Int) =
        buildWithAlgorithm(rows, columns, BinaryTree)


    fun sidewinder(rows: Int, columns: Int) =
        buildWithAlgorithm(rows, columns, Sidewinder)

    private fun buildWithAlgorithm(rows: Int, columns: Int, algorithm: Algorithm) =
        Grid(rows, columns).also { algorithm.applyTo(it) }
}
