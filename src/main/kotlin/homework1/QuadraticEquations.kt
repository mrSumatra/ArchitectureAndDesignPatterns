import kotlin.math.pow
import kotlin.math.sqrt

private const val e: Double = 1e-5
fun solve(a: Double, b: Double, c: Double): List<Double> {
    checkNotZero(a)
    val desc = getDiscriminant(a, b, c)
    return when {
        desc > e -> {
            val x1 = -b + sqrt(desc) / (2 * a)
            val x2 = -b - sqrt(desc) / (2 * a)
            listOf(x1, x2)
        }

        desc <= e -> {
            val x = -b / (2 * a)
            listOf(x)
        }
        desc < -e -> { listOf() }
        else -> listOf()
    }
}

private fun checkNotZero(a: Double) {
    if (a <= e) {
        throw ArithmeticException("a=0")
    }
}

private fun getDiscriminant(a: Double, b: Double, c: Double) = b.pow(2) - 4 * a * c