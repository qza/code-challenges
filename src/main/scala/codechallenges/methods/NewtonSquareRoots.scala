package codechallenges.methods

object NewtonSquareRoots extends App {

  println(root(2));
  println(root(4));
  println(root(100));

  def abs(x: Double) = if (x < 0) -x else x

  def mean(x: Double, y: Double): Double = (x + y) / 2

  def isConvergence(x: Double, y: Double): Boolean = abs(x - y) < 0.001

  def rootIt(estimation: Double, quotient: Double, value: Double): Double = {
    if (isConvergence(estimation, quotient)) estimation
    else rootIt(mean(estimation, value / estimation), value / estimation, value)
  }

  def root(value: Double): Double = rootIt(1.0, value, value)

}