package codechallenges.scala.dp;

import codechallenges.scala.UnitSpec

class LongestCommonSubsequenceTest extends UnitSpec {

  "LCS for Array(1), Array(1)" should "be Array(1)" in {
    val result = LongestCommonSubsequence.solve(Array(1), Array(1))
    assert(result.deep == Array(1).deep)
  }

  "LCS for Array(1, 1), Array(1)" should "be Array(1)" in {
    val result = LongestCommonSubsequence.solve(Array(1, 1), Array(1))
    assert(result.deep == Array(1).deep)
  }

  "LCS for Array(1), Array(1, 1)" should "be Array(1)" in {
    val result = LongestCommonSubsequence.solve(Array(1), Array(1, 1))
    assert(result.deep == Array(1).deep)
  }

  "LCS for Array(1, 3, 5, 7, 9), Array(2, 5, 3, 5, 7, 8)" should "be Array(3,5,7)" in {
    val result = LongestCommonSubsequence.solve(Array(1, 3, 5, 7, 9), Array(2, 5, 3, 5, 7, 8))
    assert(result.deep == Array(3, 5, 7).deep)
  }

  "LCS for Array(1, 1, 2, 1, 2), Array(1, 1, 3, 1, 3, 1)" should "be Array(1,1)" in {
    val result = LongestCommonSubsequence.solve(Array(1, 1, 2, 1, 2), Array(1, 1, 3, 1, 3, 1))
    assert(result.deep == Array(1, 1).deep)
  }

}
