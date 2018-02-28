// references:
// 1. http://aperiodic.net/phil/scala/s-99/p26.scala
// NOTE: The above link has a more elegant (and functional[?] albeit recursive) solution

package problems.p26

import org.scalatest.Assertions.assertThrows

object P26 {

  def main(args: Array[String]): Unit = {
    // case 01
    assertThrows[IllegalArgumentException] {
      combinations(10, List(1))
    }

    // case 02
    assert(combinations(1, List(1, 2)) == List(List(1), List(2)))

    // case 03
    assert(combinations(2, List(1, 2)) == List(List(1, 2)))

    // case 04
    assert(combinations(0, List(1, 2)) == List(List()))

    // case 05
    assert(combinations(2, List(1, 2, 3)) == List(List(1, 2), List(1, 3), List(2, 3)))

    // case 06
    assert(combinations(1, List(1, 2, 3)) == List(List(1), List(2), List(3)))
  }

  def combinations[A](k: Int, ls: List[A]): List[List[A]] = {
    def combinationRecursive(start: Int, remaining: Int, intermediate: List[A]): List[List[A]] = (remaining, start) match {
      case (r, _) if r == 0 =>
        // we have reached the end of the list
        List(intermediate)

      case (r, s) =>
        // we have to continue to pick elements
        (s until ls.length).map { st =>
          combinationRecursive(st + 1, r - 1, intermediate :+ ls(st))
        }.foldLeft(List[List[A]]()) { (elem, list) =>
          elem ::: list
        }

    }

    if (k > ls.length) throw new IllegalArgumentException()

    combinationRecursive(0, k, List())
  }
}
