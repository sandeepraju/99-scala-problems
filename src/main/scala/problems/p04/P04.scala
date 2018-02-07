// references:
// 1. http://aperiodic.net/phil/scala/s-99/p04.scala
//
// NOTE: The above link has a very interesting comment
// about tail recursive optimization in scala
//
// TL;DR: scala will do tail recursion optimization
// if the recursive function is either local or final

package problems.p04

import org.scalatest.Assertions._

object P04 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(length(List()) == 0)

    // case 02
    assert(length(List(0, 1, 4)) == 3)
  }

  def length[A](ls: List[A]): Int = ls match {
    case (Nil) => 0
    case (_ :: tail) => 1 + length(tail)
  }
}
