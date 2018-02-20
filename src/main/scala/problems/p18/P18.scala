// references:
// 1. http://aperiodic.net/phil/scala/s-99/p18.scala

package problems.p18

import scala.annotation.tailrec

object P18 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      List('d, 'e, 'f, 'g))

    // case 02
    assert(slice(0, 0, List()) == List())

    // case 03
    assert(slice(0, 0, List()) == List())

    // case 04
    assert(slice(10, 0, List()) == List())

    // case 05
    assert(slice(10, 0, List(1, 2, 3)) == List())

    // case 06
    assert(slice(2, 2, List(1, 2, 3)) == List())

    // case 07
    assert(slice(2, 3, List(1, 2, 3)) == List(3))

    // case 08
    assert(slice(2, 4, List(1, 2, 3, 4, 5)) == List(3, 4))

    // case 09
    assert(slice(2, 40, List(1, 2, 3, 4, 5)) == List(3, 4, 5))

    // case 10
    assert(slice(-2, -40, List(1, 2, 3, 4, 5)) == List())

  }

  def slice[A](from: Int, until: Int, ls: List[A]): List[A] = {

    // builtin
    // ls.slice(from, until)

    @tailrec
    def sliceRecursive(idx: Int, currentList: List[A], resultList: List[A]): List[A] = (idx, currentList) match {
      // before the range
      case (i, _ :: tail) if i < from => sliceRecursive(idx + 1, tail, resultList)

      // we are in the range to slice
      case (i, head :: tail) if i >= from && i < until => sliceRecursive(idx + 1, tail, resultList :+ head)

      // we have reached the end of range for slicing
      case (i, _) if i >= until => resultList

      // We have reached the end of list, return the result
      case (_, Nil) => resultList

      // invalid case
      case (_, _) if until >= from => resultList
    }

    sliceRecursive(0, ls, Nil)
  }
}
