fun main() {
    solution(3)
}

fun solution(n: Int): MutableList<MutableList<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        val innerList = mutableListOf<Int>()
        for (j in 0 until n) {
            innerList.add(0)
        }
        list.add(innerList)
    }

    var k = 0
    var l = 0

    var currentValue = 1

    var breaker = 0

    while (true) {
        if (currentValue > (n * n))
            break
        for (j in k until n - breaker) {
            list[k][j] = currentValue++
            l = j
        }
        k++
        if (currentValue > (n * n))
            break
        for (i in k until n - breaker) {
            list[i][l] = currentValue++
            k = i
        }
        l--
        if (currentValue > (n * n))
            break
        for (j in l downTo 0 + breaker) {
            list[k][j] = currentValue++
            l = j
        }
        k--
        breaker++
        if (currentValue > (n * n))
            break
        for (i in k downTo 0 + breaker) {
            list[i][l] = currentValue++
            k = i
        }
    }
    return list
}