// references:
// 1. http://aperiodic.net/phil/scala/s-99/p07.scala

package problems.p07

import org.scalatest.Assertions._

object P07 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(flatten(List(1, 2, 3)) == List(1, 2, 3))

    // case 02
    assert(flatten(List(1)) == List(1))

    // case 03
    assert(flatten(List()) == List())

    // case 04
    assert(flatten(List(List())) == List())

    // case 04
    assert(flatten(List(List(List(List())))) == List())

    // case 04
    assert(flatten(List(1, 2, List(3, 4, List(5, List(6, List(), 7), 8)), 9)) == List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  def flattenN00b[A](ls: Any): List[Int] = {

    def flattenRecursive[B](l: B): List[Any] = l match {
      case number: Int => List(number)
      case anyList: List[_] => anyList.flatten(flattenRecursive)
      case _ => throw new IllegalArgumentException
    }

    flattenRecursive(ls).asInstanceOf[List[Int]]
  }

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case list: List[_] => flatten(list)
    case element => List(element)
  }

}
