// references:
// 1. http://aperiodic.net/phil/scala/s-99/p20.scala
// NOTE: The above link has a recursive implementation
// which partially uses builtins.

package problems.p21

import java.util.NoSuchElementException
import org.scalatest.Assertions._

object P20 {

  def main(args: Array[String]): Unit = {
    // case 01
    assert(removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))

    // case 02
    assertThrows[NoSuchElementException] {
      removeAt(10, List(1, 2))
    }

    // case 03
    assertThrows[NoSuchElementException] {
      removeAt(-1, List(1, 2))
    }

  }

  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = {
    if (n < 0 || n >= ls.length) throw new NoSuchElementException()

    val (first, second) = ls.splitAt(n)
    (first ::: second.tail, second.head)
  }
}
