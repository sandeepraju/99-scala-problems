// references:
// 1. http://aperiodic.net/phil/scala/s-99/p10.scala
// NOTE: The above solution uses the `pack` function from p09
// and builds on top of that which is even more elegant.

package problems.p10

import org.scalatest.Assertions._

object P10 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))

    // case 02
    assert(encode(List('a, 'a, 'a, 'a)) == List((4,'a)))

    // case 03
    assert(encode(List()) == List())

    // case 04
    assert(encode(List('a)) == List((1,'a)))
  }

  def encode[A](ls: List[A]): List[(Int, A)] = {
    if (ls.isEmpty) List[(Int, A)]()
    else {
      val (packed, next) = ls.span(_ == ls.head)
      if (next == Nil) List((packed.size, packed.head)) else (packed.size, packed.head) :: encode(next)
    }
  }
}
