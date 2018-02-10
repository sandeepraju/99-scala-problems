// references:
// 1. http://aperiodic.net/phil/scala/s-99/p09.scala

package problems.p09

import org.scalatest.Assertions._

object P09 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))

    // case 02
    assert(pack(List()) == List(List()))

    // case 03
    assert(pack(List(1, 1, 1)) == List(List(1, 1, 1)))

    // case 04
    assert(pack(List(1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1)) == List(List(1, 1, 1), List(2), List(1, 1, 1), List(2), List(1, 1, 1, 1)))
  }

  def packIterative[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List[List[A]]()
    else {
      ls.foldLeft(List[List[A]]()) { (list, element) =>
        if (list.nonEmpty && list.last.nonEmpty && list.last.last == element) {
          list.reverse match {
            case head :: tail => ((element :: head) :: tail).reverse
            case head :: Nil =>  List(element :: head)
          }
        } else {
          list :+ List[A](element)
        }
      }
    }
  }

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls.span(_ == ls.head)
      if (next == Nil) List(packed) else packed :: pack(next)
    }
  }
}
