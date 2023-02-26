package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Grid

interface Algorithm {
    fun applyTo(grid: Grid)
}
