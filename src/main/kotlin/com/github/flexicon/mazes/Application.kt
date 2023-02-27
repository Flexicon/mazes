package com.github.flexicon.mazes

import com.github.flexicon.mazes.transformers.toAscii

fun main() {
    val btree = Maze.binaryTree(10, 10)
    println(btree.toAscii())
}
