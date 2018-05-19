import scala.collection.mutable
/** 21 5 2
  *
  * @author Evgeniy
  * @version 0.1
  */

object Main {
  def main(args: Array[String]): Unit = {
    val A = new Coordinate(10,2)
    val B = new Coordinate(12,5)
    val C = new Coordinate(14,20)
    val points = List(A,B,C)
    val numbers = List[List[Int]](List(12, 14), List(17, 14), List(22, 1), List(22, 100))
    val list = List[String]("1", "2-3", "4 5")
    println(find(points))
    println(myFlatten(numbers))
    println(toSymbol(list));
  }

  /**
    * This function find max distance between points
    * @param ls
    * @return
    */

  def find(ls:List[Coordinate]):Double ={
    val tempList:mutable.MutableList[Double] = mutable.MutableList.empty[Double]
    for ( i <-0 to  (ls.size-1) )  {
      for ( j <- i+1 to ls.size-1){
        tempList += distance(ls(i), ls(j))
      }
    }
    tempList.max
  }

  /**
    * Formula calculate distance
    * @param point
    * @param point2
    * @return
    */
  def distance(point:Coordinate, point2: Coordinate): Double = {
    math.sqrt(math.pow((point2.x - point.x),2) + math.pow((point2.y - point.y),2))
  }

  /**
    * Function add value
    * @param xs
    * @param ys
    * @tparam Any
    * @return
    */
 def append[Any](xs: List[Any], ys: List[Any]): List[Any] = xs.foldRight(ys)(_ :: _)

  /**
    * This function concatenate list of lists
    * @param xs
    * @tparam Any
    * @return
    */
 def myFlatten[Any](xs: List[List[Any]]): List[Any] = xs.foldRight(List.empty[Any])(append)

  /**
    * thid function make from string to symbol
    * @param mass
    * @return
    */
  def toSymbol(mass: List[String]): List[Char] = {
    mass.flatMap { x => x }
    //test
  }
}