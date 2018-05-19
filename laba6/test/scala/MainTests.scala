import org.scalatest._

class MainTests extends FlatSpec with Matchers {

  it should "Check Formula distance:" in{
    val A = new Coordinate(14,13)
    val B = new Coordinate(1,1)
    Main.distance(A,B) should be(17.69180601295413)
  }

  it should "Check  function Flatten:" in{
    val numbers = List[List[Int]](List(1, 2), List(3, 4))
    Main.myFlatten(numbers) should be(List(1,2,3,4))
  }

  it should "Check function String to Char" in {
    val list = List[String]("1", "12" ,"   2")
    Main.toSymbol(list) should be(List('1', '1', '2', ' ', ' ', ' ', '2'))
  }
}