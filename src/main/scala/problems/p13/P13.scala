// references:
// 1. http://aperiodic.net/phil/scala/s-99/p13.scala

package problems.p13

import org.scalatest.Assertions._

import scala.annotation.tailrec

object P13 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      == List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))

    // case 02
    assert(encodeDirect(List()) == List())

    // case 03
    assert(encodeDirect(List('a)) == List((1, 'a)))

    // case 04
    assert(encodeDirect(List('a, 'b)) == List((1, 'a), (1, 'b)))

    // case 05
    assert(encodeDirect(List('a, 'a)) == List((2, 'a)))
  }

  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    def recursiveEncodeDirectly[A](ls: List[A]): List[(Int, A)] = ls.span(ls.nonEmpty && _ == ls.head) match {
      case (Nil, Nil) => List()
      case (left, right) => (left.length, left.head) :: recursiveEncodeDirectly(right)
    }

    @tailrec
    def tailRecursiveEncodeDirectly[A](ls: List[A], res: List[(Int, A)]): List[(Int, A)] = ls.span(ls.nonEmpty && _ == ls.head) match {
      case (Nil, Nil) => res
      case (left, right) => tailRecursiveEncodeDirectly(right, res :+ (left.length, left.head))
    }

    // recursiveEncodeDirectly(ls)
    tailRecursiveEncodeDirectly(ls, List())
  }
}
