package y2022

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val cycles = listOf(20, 60, 100, 140, 180, 220) // adjust this for the desired cycles
    val program = mutableListOf<Pair<String, Int>>()
    readFileAsLinesUsingUseLines("src/main/resources/y2022/day10.txt").forEach {
        if (it == "noop") program.add(Pair(it, 0)) else {
            val instruction = it.substringBefore(" ")
            val amount = it.substringAfter(" ")
            program.add(Pair(instruction, 0))
            program.add(Pair(instruction, amount.toInt()))
        }
    }

    fun part1() {
        var ans = 0
        cycles.forEach {cycle ->
            val cycleCommand = program[cycle - 1]
            val register = 1 + (program.subList(0, cycle - 1).sumBy { it.second })
            val strength = cycle * register
            println("Strength is $strength for cycle $cycle and register is $register. Cycle command is $cycleCommand")
            ans += strength
        }
        println("The signal strength is $ans")
    }

    fun part2() {
    }
    part1()
    part2()
}