// references:
// 1. http://aperiodic.net/phil/scala/s-99/p19.scala
// NOTE: The above link has a more _elegant_ solution

package problems.p19

import scala.annotation.tailrec

object P19 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))

    // case 02
    assert(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))

    // case 03
    assert(rotate(0, List()) == List())

    // case 04
    assert(rotate(1, List()) == List())

    // case 05
    assert(rotate(-1, List()) == List())

    // case 06
    assert(rotate(2, List(1)) == List(1))

    // case 07
    assert(rotate(3, List(1)) == List(1))

    // case 08
    assert(rotate(-3, List(1)) == List(1))

    // case 09
    assert(rotate(3, List(1, 2, 3)) == List(1, 2, 3))

    // case 10
    assert(rotate(1, List(1, 2, 3)) == List(2, 3, 1))
  }

  def rotate[A](n: Int, ls: List[A]): List[A] = {

    // NOTE: in this example, positive number indicates left & negative indicates right
    @tailrec
    def rotateRecursive(idx: Int, ls: List[A]): List[A] = (idx, ls) match {
      case (_, Nil) => ls
      case (i, _) if i == 0 => ls

      // negative number, so increment (direction: right)
      case (i, l) if i < 0 =>
        // take the last and put it as head
        val head :: tail = l.reverse
        rotateRecursive(idx + 1, head :: tail.reverse)

      // positive number, so decrement (direction: left)
      case (i, l) if i > 0 =>
        // take the head and put it in the last
        val head :: tail = l
        rotateRecursive(idx - 1, tail :+ head)
    }

    rotateRecursive(n, ls)
  }
}
