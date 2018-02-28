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
    assert(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) == List('h, 'a, 'g))

    // case 02
    assertThrows[NoSuchElementException] {
      randomSelect(3, List()) == List()
    }

    // case 03
    assert(randomSelect(1, List('a, 'b)) == List('b))

    // case 04
    assert(randomSelect(3, List('a, 'b, 'c)) == List('b, 'c, 'a))

    // case 05
    assert(randomSelect(1, List('a)) == List('a))

    // case 06
    assert(randomSelect(6, List('a, 'b, 'c, 'd, 'e, 'f)) == List('e, 'a, 'c, 'f, 'd, 'b))
  }

  def randomSelect[A](n: Int, ls: List[A]): List[A] = {

    // NOTE: removeAt taken from P20
    def removeAt(n: Int, ls: List[A]): (List[A], A) = {
      if (n < 0 || n >= ls.length) throw new NoSuchElementException()

      val (first, second) = ls.splitAt(n)
      (first ::: second.tail, second.head)
    }

    @tailrec
    def randomSelectTailRecursive(idx: List[Int], ls: List[A], result: List[A]): List[A] = idx match {
      case i if i.length > ls.length => throw new NoSuchElementException()
      case Nil => result
      case (_ :: tail) =>
        val removeIdx = Random.nextInt(ls.length)
        val (nextList, removed) = removeAt(removeIdx, ls)
        randomSelectTailRecursive(tail, nextList, removed :: result)
    }

    randomSelectTailRecursive((0 until n).toList, ls, Nil)
  }
}
