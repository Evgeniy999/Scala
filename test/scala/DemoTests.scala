import org.scalatest._

class DemoTests extends FlatSpec with Matchers {
  it should "Check degree of number rec" in {
    Demo.degreeOfNumber(2,2) should be(4)
  }

  it should "Check degree of number tailrec " in {
    Demo.degreeOfNumberTail(2,2,1) should be(4)
  }

  it should " number is prime rec" in {
    Demo.isPrime(3) should be(true)
  }

  it should " number is prime tailrec" in {
    Demo.isPrimeTailRec(3) should be(true)
  }
}
