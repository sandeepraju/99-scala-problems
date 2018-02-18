// references:
// 1. http://aperiodic.net/phil/scala/s-99/p17.scala

package problems.p17

import org.scalatest.Assertions._

import scala.annotation.tailrec

object P17 {
  def main(args: Array[String]): Unit = {
    assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ==
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {

    // Using builtin
    // ls.splitAt(n)

    // Using other builtin
    // (ls.take(n), ls.drop(n))

    // Recursive solution
    // TODO: implement a recursive solution
  }
}
