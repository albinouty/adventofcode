package y2015

import java.math.BigInteger
import java.security.MessageDigest

fun main(args: Array<String>) {
    //adjust this for the day's specific data
    val zeros = 6
    val secretKey = "iwrupvqb"
    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun part1() {
        var ans = 0
        for(i in 1..100000000) {
            val s = "$secretKey$i"
            val hash = md5(s).substring(0..4)
            if(hash == "00000") {
                ans = i
                break
            }
            if(i % 100000 == 0) {
                println("$i")
            }
        }
        println("The answer is $ans")
    }

    fun part2() {
        var ans = 0
        var iter = 1000000
        val b = true
        while(b) {
            val s = "$secretKey$iter"
            val hash = md5(s).substring(0 until zeros)
            if(hash == "000000") {
                ans = iter
                break
            }
            if(iter % 1000000 == 0) {
                println("$iter")
            }
            iter ++
        }
        println("The answer is $ans")
    }
//    part1()
    part2()
}