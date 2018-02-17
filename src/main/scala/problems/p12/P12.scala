// references:
// 1. http://aperiodic.net/phil/scala/s-99/p12.scala

package problems.p12

import org.scalatest.Assertions._

object P12 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

    // case 02
    assert(decode(List()) == List())

    // case 03
    assert(decode(List((4, 'a))) == List('a, 'a, 'a, 'a))

    // case 04
    assert(decode(List((1, 'a))) == List('a))
  }

  def decode[A](ls: List[(Int, A)]): List[A] = ls.flatMap(x => List.fill(x._1)(x._2))
}
