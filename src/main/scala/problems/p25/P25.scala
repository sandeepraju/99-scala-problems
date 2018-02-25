// references:
// 1. http://aperiodic.net/phil/scala/s-99/p25.scala

package problems.p25

import scala.util.Random

object P25 {

  Random.setSeed(1337)

  def main(args: Array[String]): Unit = {
    // case 01
    assert(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) == List('a, 'e, 'c, 'd, 'f, 'b))

    // case 02
    assert(randomPermute(List()) == List())

    // case 03
    assert(randomPermute(List('a)) == List('a))
  }

  def randomPermute[A](ls: List[A]): List[A] = {
    // Built-in
    Random.shuffle(ls)

    import problems.p23.P23

    P23.randomSelect(ls.length, ls)
  }
}
