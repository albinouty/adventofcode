package y2015

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2015/day5.txt")

    fun part1() {
        val vowels = Regex("[aeiou]")
        val doubleChar = Regex("(.)\\1")
        val notBad = Regex("^((?!ab|cd|pq|xy).)*${'$'}")
        var nice = 0
        var naughty = 0
        input.forEach {
            if(notBad.containsMatchIn(it)) {
                if(doubleChar.containsMatchIn(it)) {
                    if(vowels.findAll(it).count() >= 3) {
                        nice++
                    } else naughty ++
                } else naughty ++
            } else naughty++
        }
        println("The amount of nice words is $nice and naughty words is $naughty")
    }

    fun part2() {
        val doubleLetters = Regex("")
        val sandwich = Regex("")
        var nice = 0
        var naughty = 0
        input.forEach {
            if(doubleLetters.containsMatchIn(it)){
                if(sandwich.containsMatchIn(it)) {
                    nice++
                } else naughty++
            } else naughty++
        }
    }
    part1()
    part2()
}