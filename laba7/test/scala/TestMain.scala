import org.scalatest._

class TestMain extends FlatSpec with Matchers {

  it should "Check function for the first task" in {
    val numbers = List[Int](1, 2, 3, 4, 5, -1, -2, -3, -4, -5)
    Main.func(numbers) should be("15,-120")
  }


  it should "Check function for the second task" in {
    val number = 2
    val numbers = List[Int](1, 2, 3, 4, 5, -1, -2, -3, -4, -5)
    val notNumber = "LOl"
    Main.toStr(number) should be("2")
    Main.toStr(numbers) should be(" 1 2 3 4 5 -1 -2 -3 -4 -5")
    Main.toStr(notNumber) should be("Не подходит!")
  }
}