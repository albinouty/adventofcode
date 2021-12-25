import java.io.File

fun main(args: Array<String>) {
    //adjust this for the day's specific data
    fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines { it.toList() }
    val input = readFileAsLinesUsingUseLines("src/main/resources/DAY_INPUT_HERE.txt").map { it.toInt() }

    fun part1() {
    }

    fun part2() {
    }
    part1()
    part2()
}