package com.github.flexicon.mazes

class Cell(
    val row: Int,
    val column: Int,
    var north: Cell? = null,
    var east: Cell? = null,
    var south: Cell? = null,
    var west: Cell? = null,
) {
    private val links = mutableSetOf<Cell>()

    fun link(cell: Cell, bidi: Boolean = true): Cell = apply {
        links.add(cell)
        if (bidi) cell.link(this, bidi = false)
    }

    fun unlink(cell: Cell, bidi: Boolean = true): Cell = apply {
        links.remove(cell)
        if (bidi) cell.unlink(this, bidi = false)
    }

    fun isLinked(cell: Cell?) = links.contains(cell)

    val neighbors: Set<Cell>
        get() = buildSet {
            north?.let { add(it) }
            east?.let { add(it) }
            south?.let { add(it) }
            west?.let { add(it) }
        }
}
