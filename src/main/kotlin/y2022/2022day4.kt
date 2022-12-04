package y2022

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2022/day4.txt").map {
        it.split(",").map { p ->
            p.substringBefore("-").toInt() to p.substringAfter("-").toInt()
        }
    }

    fun isContained(pairOne: Pair<Int, Int>, pairTwo: Pair<Int, Int>): Boolean = pairTwo.first >= pairOne.first &&
            pairTwo.second <= pairOne.second

    fun isOverlap(pairOne: Pair<Int, Int>, pairTwo: Pair<Int, Int>): Boolean = pairOne.second >= pairTwo.first &&
            pairOne.first <= pairTwo.second

    fun part1() {
        var ans = 0
        input.forEach {
            val firstPair = it.first()
            val secondPair = it.last()
            if (isContained(firstPair, secondPair)) ans++ else {
                if (isContained(secondPair, firstPair)) ans++
            }
        }
        println("Part 1: there are $ans sets of pairs in which one pair completely contains the other.")
    }

    fun part2() {
        var ans = 0
        input.forEach {
            val firstPair = it.first()
            val secondPair = it.last()
            if (isOverlap(firstPair, secondPair)) ans++
        }
        println("Part 2: there are $ans pairs that overlap")
    }
    part1()
    part2()
}