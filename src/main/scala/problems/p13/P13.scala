// references:
// 1. http://aperiodic.net/phil/scala/s-99/p13.scala

package problems.p13

import org.scalatest.Assertions._

object P13 {
  def main(args: Array[String]): Unit = {
    // case 01
    assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  def encodeDirect[A](symbols: List[A]): List[(Int, A)] = ???
}
