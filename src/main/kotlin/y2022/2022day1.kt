package y2022

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2022/day1.txt").map { if (it == "") 0 else it.toInt() }
    fun part1() {
        var largest = 0
        var total = 0
        input.forEach { i ->
            when(i) {
                0 -> {
                    if (total > largest) largest = total
                    total = 0
                }
                else -> total += i
            }
        }
        println("The largest total calories a single elf is carrying is $largest")
    }

    fun part2() {
        val totals = mutableListOf<Int>()
        var total = 0
        var ans = 0
        input.forEachIndexed() {idx, it ->
            when(it) {
                0 -> {
                    totals.add(total)
                    total = 0
                }
                else -> {
                    total += it
                    if (input.lastIndex == idx) totals.add(total)
                }
            }
        }
        totals.sortDescending()
        repeat(3) {
            ans += totals.removeAt(0)
        }
        println("The top three combined are $ans")
    }
    part1()
    part2()
}
