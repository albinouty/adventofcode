package y2022

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String) = File(fileName).useLines { it.toList() }[0]
    val input = readFileAsLinesUsingUseLines("src/main/resources/y2022/day6.txt")
    val MARKER_SIZE = 14 // change this for the specific marker size
    fun getAnswer() {
        fun findMarker(s: String): Int {
            var marker = mutableListOf<Char>()
            s.forEachIndexed { index, c ->
                if (index > MARKER_SIZE - 2) {
                    marker.add(c)
                    if(marker.distinct().size == MARKER_SIZE) {
                        return index + 1
                    } else marker = marker.drop(1).toMutableList()
                } else marker.add(c)
            }
            return -1
        }
        println("The answer is ${findMarker(input)}")
    }
    getAnswer()
}