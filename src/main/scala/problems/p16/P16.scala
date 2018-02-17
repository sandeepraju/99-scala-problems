// references:
// 1. http://aperiodic.net/phil/scala/s-99/p16.scala

package problems.p16

import org.scalatest.Assertions._

import scala.annotation.tailrec

object P16 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))

    // case 02
    assert(drop(3, List('a)) == List('a))

    // case 03
    assert(drop(0, List('a)) == List('a))

    // case 04
    assert(drop(1, List('a)) == List())

    // case 05
    assert(drop(1, List('a, 'b)) == List())

    // case 06
    assert(drop(1, List('a, 'b, 'c, 'd, 'e)) == List())
  }

  def drop[A](n: Int, ls: List[A]): List[A] = {
    @tailrec
    def dropTailRecursive(ls: List[A], res: List[A]): List[A] = ls.splitAt(n - 1) match {
      case (Nil, Nil) => res
      case (left, Nil) => res ::: left
      case (Nil, right) => dropTailRecursive(right.tail, res)
      case (left, right) => dropTailRecursive(right.tail, res ::: left)
    }

    // this condition is required as splitAt is forgiving when n < 1
    // behavior of splitAt is same for n = 0, -1, -2 ...
    if (n < 1) ls else dropTailRecursive(ls, List())


    // Using builtin
    // if (n < 1) ls else ls.zipWithIndex.filter(x => (x._2 + 1) % n != 0).map(_._1)
  }
}
