// references:
// 1. http://aperiodic.net/phil/scala/s-99/p03.scala

package problems.p03

import org.scalatest.Assertions._

object P03 {
  def main(args: Array[String]): Unit = {
    // case 01
    assertThrows[NoSuchElementException] {
      nth(0, List())
    }

    // case 02
    assert(nth(0, List(8)) == 8,
    "`nth` should return the nth value of a list")

    // case 03
    assertThrows[NoSuchElementException] {
      nth(100, List(3))
    }

    // case 04
    assert(nth(4, List(0, 1, 2, 3, 4)) == 4,
    "`nth` should return the nth value when n is non zero")

  }

  def nthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n >= 0) ls(n)
    else throw new NoSuchElementException
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, head :: _) => head
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  def nth(n: Int, ls: List[Int]): Int = {
    nthRecursive(n, ls)
  }
}
