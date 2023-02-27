package com.github.flexicon.mazes.algorithms

import com.github.flexicon.mazes.Cell

fun Cell?.isLinked(other: Cell?) =
    this?.isLinked(other) ?: false
