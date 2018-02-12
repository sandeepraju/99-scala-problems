// references:
// 1. http://aperiodic.net/phil/scala/s-99/p11.scala
// NOTE: The above link has an alternative type safe version
// of the solution with Either & Left, Right

package problems.p11

import org.scalatest.Assertions._

object P11 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))

    // case 02
    assert(encodeModified(List()) == List())

    // case 04
    assert(encodeModified(List(1, 2, 3)) == List(1, 2, 3))

    // case 05
    assert(encodeModified(List(1, 1, 2, 1, 1)) == List((2, 1), 2, (2, 1)))

    // case 06
    assert(encodeModified(List(1)) == List(1))
  }

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls.span(_ == ls.head)
      if (next == Nil) List(packed) else packed :: pack(next)
    }
  }

  def encodeModified[A](ls: List[A]): List[Any] = {
    pack(ls).withFilter(_.nonEmpty).map { sublist =>
      if (sublist.size == 1) {
        sublist.head
      } else {
        (sublist.size, sublist.head)
      }
    }
  }
}
