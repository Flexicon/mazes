package com.github.flexicon.mazes.transformers

import com.github.flexicon.mazes.Grid
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AsciiKtTest {
    private val grid = Grid(3, 3).apply {
        link(0, 0, 0, 1)
        link(0, 1, 0, 2)

        link(1, 0, 1, 1)
        link(1, 0, 0, 0)
        link(1, 1, 1, 2)

        link(2, 0, 2, 1)
        link(2, 1, 1, 1)
        link(2, 2, 1, 2)
    }

    @Test
    fun `should print Grid to ASCII`() {
        assertEquals(
            """
            +---+---+---+
            |           |
            +   +---+---+
            |           |
            +---+   +   +
            |       |   |
            +---+---+---+
            """.trimIndent(),
            grid.toAscii()
        )
    }

    private fun Grid.link(row1: Int, col1: Int, row2: Int, col2: Int) {
        get(row1, col1)!!.link(get(row2, col2)!!)
    }
}
