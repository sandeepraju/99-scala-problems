// references:
// 1. http://aperiodic.net/phil/scala/s-99/p01.scala
// 2. http://alvinalexander.com/scala/how-to-use-lists-nil-cons-scala-match-case-expressions
package problems.p01

import org.scalatest.Assertions._

object P01 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(
      last(List(1, 2, 3)) == 3,
      "`last` of valid list should return the last element of the list"
    )

    // case 02
    assert(
      last(List(1)) == 1,
      "`last` of a list with single item should return that item"
    )

    // case 03
    assert(
      last(List("one", "two", "three")) == "three",
      "`last` should work as expected on List[String] as well"
    )

    // case 04
    assertThrows[NoSuchElementException] {
      last(null)  // `last` should throw an exception when the list is null
    }

    // case 05
    assertThrows[NoSuchElementException] {
      last(Nil)  // `last` should throw an exception when the list is Nil
    }
  }

  def last[A](ls: List[A]): A = ls match {
    case head :: Nil => head
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }
}
