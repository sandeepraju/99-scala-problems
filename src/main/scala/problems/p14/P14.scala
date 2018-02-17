// references:
// 1. http://aperiodic.net/phil/scala/s-99/p14.scala

package problems.p14

import org.scalatest.Assertions._

import scala.annotation.tailrec

object P14 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(duplicate(List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))

    // case 02
    assert(duplicate(List('a)) == List('a, 'a))

    // case 03
    assert(duplicate(List()) == List())
  }

  def duplicate[A](ls: List[A]): List[A] = ls.flatMap(x => x :: x :: Nil)
}
