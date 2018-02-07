// references:
// 1. http://aperiodic.net/phil/scala/s-99/p05.scala

package problems.p05

import org.scalatest.Assertions._

object P05 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(reverse(List(0, 1, 2)).mkString(",") == "2,1,0")

    // case 02
    assert(reverse(List(0)).mkString(",") == "0")

    // case 03
    assert(reverse(List()).mkString(",") == "")

  }

  def reverse[A](ls: List[A]): List[A] = {
    // reverseRecursive(ls)
    // reverseTailRecursive(ls)
    reversePureFunctional(ls)
  }

  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case (Nil) => List()
    case (head :: tail) => reverse(tail) ::: List(head)
  }

  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    // Not a pure function :\
    def localReverse(res: List[A], list: List[A]): List[A] = list match {
      case Nil => res
      case (head :: tail) => localReverse(head :: res, tail)
    }

    localReverse(Nil, ls)
  }

  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse

  def reversePureFunctional[A](ls: List[A]): List[A] = {
    ls.foldLeft(List[A]()) { (newList, element) =>
      // prepend the element to the new list
      element :: newList
    }
  }
}
