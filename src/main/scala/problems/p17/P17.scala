// references:
// 1. http://aperiodic.net/phil/scala/s-99/p17.scala

package problems.p17

import org.scalatest.Assertions._

import scala.annotation.tailrec

object P17 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(split(0, List()) == List().splitAt(0))

    // case 02
    assert(split(1, List()) == List().splitAt(1))

    // case 03
    assert(split(-1, List()) == List().splitAt(-1))

    // case 04
    assert(split(0, List('a)) == List('a).splitAt(0))

    // case 05
    assert(split(1, List('a)) == List('a).splitAt(1))

    // case 06
    assert(split(-1, List('a)) == List('a).splitAt(-1))

    // case 07
    assert(split(-2, List('a)) == List('a).splitAt(-2))

    // case 08
    assert(split(2, List('a)) == List('a).splitAt(2))

    // case 09
    assert(split(2, List('a, 'b)) == List('a, 'b).splitAt(2))

    // case 09
    assert(split(1, List('a, 'b)) == List('a, 'b).splitAt(1))

    // case 10
    assert(split(0, List('a, 'b)) == List('a, 'b).splitAt(0))

    // case 11
    assert(split(-1, List('a, 'b)) == List('a, 'b).splitAt(-1))

    // case 12
    assert(split(-2, List('a, 'b)) == List('a, 'b).splitAt(-2))

    // case 13
    assert(split(3, List('a, 'b)) == List('a, 'b).splitAt(3))

    // case 07
    assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {

    // Using builtin
    // ls.splitAt(n)

    // Using other builtin
    // (ls.take(n), ls.drop(n))

    // Recursive solution
    @tailrec
    def splitRecursive(idx: Int, list: List[A], left: List[A], right: List[A]): (List[A], List[A]) = idx match {
      // we have reached the end
      case i if i == ls.length => (left, right)

      // before the split
      case i if i < n => splitRecursive(idx + 1, list.tail, left :+ list.head, right)

      // after the split
      case i if i >= n  => splitRecursive(idx + 1, list.tail, left, right :+ list.head)
    }

    if (n < 0) (List(), ls)
    else if (n >= ls.length) (ls, List())
    else splitRecursive(0, ls, List[A](), List[A]())
  }
}
