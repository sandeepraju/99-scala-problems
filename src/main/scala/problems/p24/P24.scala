// references:
// 1. http://aperiodic.net/phil/scala/s-99/p24.scala
// NOTE: The above link contains a solution that uses
// the randomSelect function we wrote in P23

package problems.p24

import scala.util.Random

object P24 {

  Random.setSeed(1337)

  def main(args: Array[String]): Unit = {
    // case 01
    assert(lotto(5, 10) == List(2, 5, 10, 3, 10))

    // case 02
    assert(lotto(1, 1) == List(1))

    // case 03
    assert(lotto(0, 10) == List())

    // case 04
    assert(lotto(4, 4) == List(4, 4, 1, 3))
  }

  def lotto(n: Int, m: Int): List[Int] = List.fill(n)(1 + Random.nextInt(m))
}
