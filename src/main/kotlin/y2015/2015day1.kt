package y2015

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<Char> = File(fileName).useLines { it.toList() }.first().toList()
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2015/day1.txt")
    var basement = false
    var floor = 0
    fun travel(i: Char) {
        when(i) {
            '(' -> floor += 1
            ')' -> floor -= 1
        }
        if(floor < 0) {
            basement = true
        }
    }

    //must run part 1 and part 2 separately
    fun part1() {
        input.map {
            travel(it)
        }
        println(floor)
    }

    fun part2() {
        for((indx, i) in input.withIndex()) {
            travel(i)
            if(basement) {
                println("The position of the value that made Santa go in the basement is ${indx + 1}")
                break
            }
        }
    }
    part1()
    part2()
}