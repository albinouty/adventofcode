package y2015

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2015/day2.txt").map{
        it.split("x").map { x ->
            x.toInt()
        }
    }.map { list ->
        Triple(list[0], list[1], list[2])
    }
    var paper = 0
    fun calcPaper(i: Triple<Int, Int, Int>): Int {
        val l = i.first*i.second
        val w = i.first*i.third
        val h = i.second*i.third
        val min = listOf(l,w,h).min()!!
        return (2*h) + (2*w) + (2*l) + min
    }

    fun part1() {
        input.forEach {
            paper += calcPaper(it)
        }
        println("The amount of paper the elves need is $paper")
    }

    fun part2() {
    }
    part1()
    part2()
}