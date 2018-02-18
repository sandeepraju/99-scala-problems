// references:
// 1. http://aperiodic.net/phil/scala/s-99/p15.scala

package problems.p15

import org.scalatest.Assertions._

object P15 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) ==
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))

    // case 02
    assert(duplicateN(1, List('a)) == List('a))

    // case 03
    assert(duplicateN(2, List()) == List())

    // case 04
    assert(duplicateN(0, List('a)) == List())

    // case 05
    assert(duplicateN(2, List('a)) == List('a, 'a))
  }

  def duplicateN[A](n: Int, ls: List[A]): List[A] = ls.flatMap(x => List.fill(n)(x))
}
