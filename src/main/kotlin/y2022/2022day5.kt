package y2022

import java.io.File

fun main(args: Array<String>) {
    fun getCrates(stack: List<Char>, amount: Int): List<Char> = stack.subList(stack.size - 1 - amount, stack.size -1).reversed()
    val cratesTmp = mutableListOf<String>()
    val commandsTmp = mutableListOf<String>()
    var switch = true
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    readFileAsLinesUsingUseLines("src/main/resources/y2022/day5.txt").forEach {
        if (it.isBlank()) switch = false
        if (switch) cratesTmp.add(it) else if (it.isNotBlank())commandsTmp.add(it)
    }
    val finalCommands = commandsTmp.map {
        val first = it.substringAfter("move ").substringBefore(" from").toInt()
        val second = it.substringAfter("from ").substringBefore(" to").toInt()
        val third = it.substringAfter("to ").toInt()
        Triple(first, second, third)
    }
    val furthestStack = cratesTmp.maxBy { it.length }!!
    val numStacks = (furthestStack.length + 1) / 4
    val stackKey = mutableListOf<Int>()
    repeat(furthestStack.length) {
        if (it % 4 == 1) stackKey.add(it)
    }
    val finalCrates = HashMap<Int, MutableList<Char>>()
    repeat(numStacks) {
        finalCrates[it + 1] = mutableListOf()
    }
    cratesTmp.forEach { s ->
        s.forEachIndexed { idx, c ->
            val stack = stackKey.indexOf(idx) + 1
            if (stack > 0) {
                var tmp = finalCrates[stack]
                tmp!!.add(c)
                finalCrates[stack] = tmp.filter { it != ' ' } as MutableList<Char>
            }
        }
    }
    finalCrates.forEach {
        val tmp = it.value.dropLast(1).reversed()
        finalCrates[it.key] = tmp as MutableList<Char>
    }
    println(finalCrates)
    fun moveCrates(stack: List<Char>, command: Triple<Int, Int, Int>) {
        val lowerBound = command.first - 1
        val upperBound = command.first
        finalCrates[command.second] = finalCrates[command.second]!!.subList(0, lowerBound)
        finalCrates[command.third] =
            (stack.subList(lowerBound, upperBound).reversed() + finalCrates[command.third]!!).toMutableList()
    }
    fun part1() {
        finalCommands.forEach {
            val origin = finalCrates[it.second]!!
            moveCrates(origin, it)
        }
        var ans = ""
        finalCrates.forEach { s ->
            ans += s.value.last()
        }
        println("The answer is $ans")
    }

    fun part2() {
    }
    part1()
    part2()
}