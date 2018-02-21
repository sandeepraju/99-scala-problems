// references:
// 1. http://aperiodic.net/phil/scala/s-99/p21.scala

package problems.p21

object P21 {

  def main(args: Array[String]): Unit = {
    // case 01
    assert(insertAt('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))

    // case 02
    assert(insertAt('new, 10, List('a, 'b, 'c, 'd)) == List('a, 'b, 'c, 'd, 'new))

    // case 03
    assert(insertAt('new, -10, List('a, 'b, 'c, 'd)) == List('new, 'a, 'b, 'c, 'd))
  }

  def insertAt[A](elem: A, i: Int, list: List[A]): List[A] = list.splitAt(i) match {
    case (left, right) => left ::: (elem :: right)
  }
}
