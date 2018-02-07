// references:
// 1. http://aperiodic.net/phil/scala/s-99/p02.scala
// 2. http://alvinalexander.com/scala/how-to-extract-sequence-elements-collection-scala-cookbook

package problems.p02

import org.scalatest.Assertions._

object P02 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(
      penultimate(List(1, 2, 3)) == 2,
      "`penultimate` of valid list should return the element one away from last in the list"
    )

    // case 02
    assertThrows[NoSuchElementException] {
      penultimate(List(1))  // `penultimate` should throw an exception when the list has one item
    }

    // case 03
    assert(
      penultimate(List("one", "two", "three")) == "two",
      "`penultimate` should work as expected on List[String] as well"
    )

    // case 04
    assertThrows[NoSuchElementException] {
      penultimate(null)  // `penultimate` should throw an exception when the list is null
    }

    // case 05
    assertThrows[NoSuchElementException] {
      penultimate(Nil)  // `penultimate` should throw an exception when the list is Nil
    }
  }

  def penultimate[A](ls: List[A]): A = ls match {
    case head :: _ :: Nil => head
    case _  :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }
}
