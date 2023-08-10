package homework1

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import solve
import java.lang.Exception
import kotlin.test.assertEquals

class QuadraticEquationsTest {

    @Test
    fun `check x^2+1 = 0 not roots`() {
        val result = solve(1.0, 0.0, 1.0)
        assertEquals(result, listOf())
    }

    @Test
    fun `check x^2-1 = 0 result x1=1, x2=-1`() {
        val result = solve(1.0, 0.0, -1.0).map { it.toInt() }
        assertEquals(result, listOf(1, -1))
    }

    @Test
    fun `check x^2+2x+1 = 0 result x1= x2 = -1`() {
        val result = solve(1.0, 2.0, 1.0).map { it.toInt() }
        assertEquals(result, listOf(-1))
    }

    @Test
    fun `check exception`() {
        val exception: Exception = assertThrows(ArithmeticException::class.java) {
            solve(0.0, 2.0, 1.0)
        }
        assertEquals("a=0", exception.message)
    }

    @Test
    fun `check Discriminant`() {
        solve(0.0001, 0e8, 0e-7)
    }

}