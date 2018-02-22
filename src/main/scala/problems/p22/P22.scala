// references:
// 1. http://aperiodic.net/phil/scala/s-99/p22.scala
// NOTE: The above link has some slick tail recursive implementations

package problems.p22

object P22 {

  def main(args: Array[String]): Unit = {
    // case 01
    assert(range(4, 9) == List(4, 5, 6, 7, 8, 9))

    // case 02
    assert(range(1, 1) == List(1))

    // case 03
    assert(range(2, 1) == List())

    // case 04
    assert(range(1, 2) == List(1, 2))

  }

  def range(start: Int, end: Int): List[Int] = {
    // builtin 1
    // start to end toList

    // builtin 2
    // List.range(start, end)

    // Functional way using "unfold right"
    // NOTES:
    // - fold function folds a iterable (accumulates over the list with one element at a time)
    // - unfold takes a accumulation and generates a list (iterable)
    def unfoldr[A, B](seed: B)(f: B => Option[(A, B)]): List[A] = f(seed) match {
      case None => Nil
      case Some((result, nextSeed)) => result :: unfoldr(nextSeed)(f)
    }

    unfoldr(start) { n =>
      if (n > end) None // We should end this list now
      else Some((n, n + 1)) // Add the value of n to the list and increment the seed
    }
  }
}
