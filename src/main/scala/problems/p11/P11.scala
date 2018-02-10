// references:
// 1. http://aperiodic.net/phil/scala/s-99/p11.scala

package problems.p11

import org.scalatest.Assertions._

object P11 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }

  def encodeModified[A](ls: List[A]): List[Any] = ???
}
