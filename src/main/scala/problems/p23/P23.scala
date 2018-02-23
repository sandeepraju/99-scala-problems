// references:
// 1. http://aperiodic.net/phil/scala/s-99/p23.scala

package problems.p23

import java.util.NoSuchElementException

import org.scalatest.Assertions.assertThrows

import scala.annotation.tailrec
import scala.util.Random

object P23 {

  Random.setSeed(1337L)

  def main(args: Array[String]): Unit = {
    // case 01
    assert(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) == List('f, 'a, 'b))

    // case 02
    assertThrows[NoSuchElementException] {
      assert(randomSelect(3, List()) == List())
    }

    // case 03
    assert(randomSelect(1, List('a, 'b)) == List('a))

    // case 04
    assert(randomSelect(3, List('a, 'b, 'c)) == List('a, 'c, 'b))
  }

  def randomSelect[A](n: Int, ls: List[A]): List[A] = {

    // NOTE: removeAt taken from P20
    def removeAt(n: Int, ls: List[A]): (List[A], A) = {
      if (n < 0 || n >= ls.length) throw new NoSuchElementException()

      val (first, second) = ls.splitAt(n)
      (first ::: second.tail, second.head)
    }

    @tailrec
    def randomSelectTailRecursive(picks: List[Int], ls: List[A], result: List[A]): List[A] = picks match {
      case Nil => result
      case (head :: tail) =>
        val (nextList, removed) = removeAt(head, ls)
        randomSelectTailRecursive(tail, nextList, removed :: result)
    }

    val picks = (0 until n).map(_ => Random.nextInt(n)).toList
    randomSelectTailRecursive(picks, ls, Nil)
  }
}
