// references:
// 1. http://aperiodic.net/phil/scala/s-99/p08.scala
// NOTE: refer the above link for a nice recursive implementation

package problems.p08

import org.scalatest.Assertions._

object P08 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List('a, 'b, 'c, 'a, 'd, 'e))

    // case 02
    assert(compress(List()) == List())

    // case 03
    assert(compress(List(1, 2, 3)) == List(1, 2, 3))

    // case 04
    assert(compress(List(1)) == List(1))

    // case 05
    assert(compress(List(1, 1, 1)) == List(1))
  }

  def compress[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) { (list, element) =>
    if (list.nonEmpty && list.last == element) list else list :+ element
  }
}
