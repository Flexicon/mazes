package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Grid
import kotlin.random.Random

class Sidewinder internal constructor(private val rand: Random = Random) : Algorithm {
    override fun applyTo(grid: Grid) {
        TODO("Not yet implemented")
    }

    companion object : Algorithm by Sidewinder()
}
