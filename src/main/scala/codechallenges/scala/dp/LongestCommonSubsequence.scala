package codechallenges.scala.dp

import scala.math._

object LongestCommonSubsequence extends App {

  println
  print(solve(Array(1, 1), Array(1)))
  println
  print(solve(Array(1, 3, 5, 7, 9), Array(2, 5, 3, 5, 7, 8)))
  println
  print(solve(Array(1, 1, 2, 1, 2), Array(1, 1, 3, 1, 3, 1)))
  println

  def solve(arrA: Array[Int], arrB: Array[Int]): Array[Int] = {

    val lengths = Array.ofDim[Int](arrA.size + 1, arrB.size + 1)

    for (i <- 1 until arrA.size) {
      for (j <- 1 until arrB.size) {
        if (arrA(i) == arrB(j)) {
          lengths(i)(j) = lengths(i - 1)(j - 1) + 1
        } else {
          lengths(i)(j) = max(lengths(i - 1)(j), lengths(i)(j - 1))
        }
      }
    }

    def elements(i: Int, j: Int): Array[Int] = {
      if (i == 0 || j == 0) Array.emptyIntArray
      else if (arrA(i - 1) == arrB(j - 1)) Array.concat(elements(i - 1, j - 1), Array(arrA(i - 1)))
      else if (lengths(i - 1)(j) > lengths(i)(j - 1)) elements(i - 1, j)
      else elements(i, j - 1)
    }

    elements(arrA.size, arrB.size)
  }

  def print(arr: Array[Int]) = {
    arr.map(x => println(x))
  }

}