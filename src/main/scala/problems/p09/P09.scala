// references:
// 1.

package problems.p09

import org.scalatest.Assertions._

object P09 {
  def main(args: Array[String]): Unit = {
    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  def pack[A](ls: List[A]): List[List[A]] = ???
}
