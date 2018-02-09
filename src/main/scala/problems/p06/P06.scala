// references:
// 1. http://aperiodic.net/phil/scala/s-99/p06.scala

package problems.p06

import org.scalatest.Assertions._

object P06 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(isPalindrome(List()))

    // case 02
    assert(!isPalindrome(List(1, 2, 3)))

    // case 03
    assert(isPalindrome(List(1, 2, 1)))

    // case 04
    assert(isPalindrome(List(1, 1, 1)))

    // case 05
    assert(isPalindrome(List(1, 1)))

    // case 06
    assert(isPalindrome(List(1)))
  }

  // O(n^2) algorithm
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse
}
