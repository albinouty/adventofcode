package y2022

import java.io.File

enum class Shape(val equivalent: Char, val beats: Char, val beatBy: Char, val point: Int) {
    ROCK('A', 'C', 'B', 1),
    PAPER('B', 'A', 'C', 2),
    SCISSORS('C', 'B', 'A', 3);
}

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2022/day2.txt").map {
        it.split(" ")
        it.first() to it.last()
    }

    fun determineShape(c: Char): Shape {
        return when (c) {
            'X', 'A' -> Shape.ROCK
            'Y', 'B' -> Shape.PAPER
            else -> Shape.SCISSORS
        }
    }

    fun part1() {
        var totalScore = 0
        input.forEach {
            val myShape = determineShape(it.second)
            totalScore += if (it.first == myShape.equivalent) {
                3 + myShape.point
            } else if (myShape.beats == it.first) {
                6 + myShape.point
            } else myShape.point
        }
        println("Part 1: The total score is $totalScore")
    }

    fun part2() {
        var totalScore = 0
        input.forEach {
            totalScore += when (it.second) {
                'X' -> determineShape(determineShape(it.first).beats).point
                'Y' -> 3 + determineShape(it.first).point
                else -> 6 + determineShape(determineShape(it.first).beatBy).point
            }
        }
        print("Part 2: The total score is $totalScore")
    }
    part1()
    part2()
}