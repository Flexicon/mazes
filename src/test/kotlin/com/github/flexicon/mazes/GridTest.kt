package com.github.flexicon.mazes

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class GridTest {

    @Test
    fun `should prepare proper grid`() {
        val grid = Grid(2, 2)

        run {
            val cell = grid[0, 0]
            assertNotNull(cell)
            assertNull(cell.north)
            assertNull(cell.west)
            assertEquals(grid[0, 1], cell.east)
            assertEquals(grid[1, 0], cell.south)
        }

        run {
            val cell = grid[0, 1]
            assertNotNull(cell)
            assertNull(cell.north)
            assertNull(cell.east)
            assertEquals(grid[0, 0], cell.west)
            assertEquals(grid[1, 1], cell.south)
        }

        run {
            val cell = grid[1, 0]
            assertNotNull(cell)
            assertNull(cell.south)
            assertNull(cell.west)
            assertEquals(grid[1, 1], cell.east)
            assertEquals(grid[0, 0], cell.north)
        }

        run {
            val cell = grid[1, 1]
            assertNotNull(cell)
            assertNull(cell.south)
            assertNull(cell.east)
            assertEquals(grid[1, 0], cell.west)
            assertEquals(grid[0, 1], cell.north)
        }

        // Assert out of bounds lookups
        assertNull(grid[-1, 0])
        assertNull(grid[0, -1])
        assertNull(grid[grid.rows, 0])
        assertNull(grid[0, grid.columns])
    }

    @Test
    fun `forEachCell runs through each cell`() {
        val grid = Grid(2, 2)
        val allCells = listOf(grid[0, 0], grid[0, 1], grid[1, 0], grid[1, 1])
        val ranCells = mutableListOf<Cell>()

        grid.forEachCell { ranCells.add(it) }

        assertEquals(grid.rows * grid.columns, ranCells.size)
        assertEquals(allCells, ranCells)
    }
}
