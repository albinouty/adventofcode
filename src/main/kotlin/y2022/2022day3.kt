package y2022

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val inputPart1 = readFileAsLinesUsingUseLines("src/main/resources/y2022/day3.txt").map {
        val halfLen = it.length / 2
        val firstHalf = hashSetOf<Char>()
        it.subSequence(0, halfLen).forEach { c ->
            firstHalf.add(c)
        }
        val secondHalf = hashSetOf<Char>()
        it.subSequence(halfLen, it.length).forEach { c ->
            secondHalf.add(c)
        }
        firstHalf to secondHalf
    }

    fun generateAlphabet(): HashMap<Char, Int> {
        val values = hashMapOf<Char, Int>()
        ('A'..'Z').toMutableList().forEachIndexed { index, c ->
            val lower = c.toLowerCase()
            values[lower] = index + 1
            values[c] = index + 1 + 26
        }
        return values
    }
    val alphabet = generateAlphabet()

    fun part1() {
        var ans = 0
        inputPart1.forEach {
            it.first.retainAll(it.second)
            ans += alphabet[it.first.first()]!!
        }
        println("The answer for part 1 is $ans")
    }

    fun part2() {
        var ans = 0
        val inputDay2 = readFileAsLinesUsingUseLines("src/main/resources/y2022/day3.txt").map { it.toCharArray() }
        val groups = inputDay2.chunked(3)
        groups.forEach {
            var commons = it[0].intersect(it[1].toSet())
            commons = it[2].intersect(commons)
            ans += alphabet[commons.first()]!!
        }
        println("The answer for part 2 is $ans")
    }
    part1()
    part2()
}