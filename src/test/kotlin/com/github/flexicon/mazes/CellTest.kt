package com.github.flexicon.mazes

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CellTest {

    @Test
    fun `should link and unlink cells`() {
        val cell1 = Cell(1, 1)
        val cell2 = Cell(1, 2)

        assert(!cell1.isLinked(cell2))
        assert(!cell2.isLinked(cell1))

        cell1.link(cell2)
        assert(cell1.isLinked(cell2))
        assert(cell2.isLinked(cell1))

        cell1.unlink(cell2)
        assert(!cell1.isLinked(cell2))
        assert(!cell2.isLinked(cell1))
    }

    @Test
    fun `should return appropriate neighbors`() {
        val cell = Cell(2, 3)
        assertEquals(emptySet(), cell.neighbors)

        val nCell = Cell(3, 3)
        cell.north = nCell
        assertEquals(setOf(nCell), cell.neighbors)

        val eCell = Cell(2, 4)
        cell.east = eCell
        assertEquals(setOf(nCell, eCell), cell.neighbors)

        val sCell = Cell(1, 3)
        cell.south = sCell
        assertEquals(setOf(nCell, eCell, sCell), cell.neighbors)

        val wCell = Cell(2, 2)
        cell.west = wCell
        assertEquals(setOf(nCell, eCell, sCell, wCell), cell.neighbors)

        val nCell2 = Cell(nCell.row, nCell.column)
        cell.north = nCell2
        assertEquals(setOf(nCell2, eCell, sCell, wCell), cell.neighbors)

        cell.east = null
        assertEquals(setOf(nCell2, sCell, wCell), cell.neighbors)
    }
}
