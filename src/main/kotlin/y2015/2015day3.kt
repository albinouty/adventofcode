package y2015

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): String = File(fileName).useLines { it.first() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2015/day3.txt").toList()
    val houses = mutableListOf<Pair<Int,Int>>()
    var x = 0
    var y = 0
    var ry = 0
    var rx = 0
    houses.add(Pair(x,y))
    fun move(c: Char, roboSanta: Boolean): Pair<Int,Int> {
        if(!roboSanta) {
            when(c) {
                '^' -> y++
                'v' -> y--
                '>' -> x++
                '<' -> x--
            }
            return Pair(x,y)
        } else {
            when(c) {
                '^' -> ry++
                'v' -> ry--
                '>' -> rx++
                '<' -> rx--
            }
            return Pair(rx,ry)
        }
    }

    fun part1() {
        input.forEach {
            houses.add(move(it, false))
        }
        val uniqueHouses = houses.toHashSet()
        println("The number of unique houses visited at least once is ${uniqueHouses.size}")
    }

    val partTwoHouses = mutableListOf<Pair<Int,Int>>()
    partTwoHouses.add(Pair(rx,ry))
    fun part2() {
        x = 0
        y = 0
        val santaRoute = input.filterIndexed { indx, _ ->
            indx % 2 != 0
        }
        val roboRoute = input.filterIndexed { indx, _ ->
            indx % 2 == 0
        }
        santaRoute.forEach {
            partTwoHouses.add(move(it, false))
        }
        roboRoute.forEach {
            partTwoHouses.add(move(it, true))
        }
        val uniqueHouses = partTwoHouses.toHashSet()
        println("The number of unique houses visited at least once is ${uniqueHouses.size}")
    }
    part1()
    part2()
}