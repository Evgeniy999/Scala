import scala.annotation.tailrec
import scala.collection.mutable

/**
  * @author Evgeniy
  * @version 0.1
  */

object Main {
  def main(args: Array[String]): Unit = {
    val numbers = List[Int](1, -2, 5,-3, 2,-3)
    val num:Int=2
    val num2:String="lol"
    println(func(numbers))
    println(toStr(numbers))
    println(toStr(num))
    println(toStr(num2))
  }

  /**
    *
    * @param numbers
    * @return - string values
    */

  def func(numbers: List[Int]): String = {
    val sum: mutable.MutableList[Int] = mutable.MutableList.empty[Int]
    val pr: mutable.MutableList[Int] = mutable.MutableList.empty[Int]

    for (i <- 0 to numbers.size - 1) {
      /*if (numbers(i) > 0) {
        sum += numbers(i)
      }
      else if(numbers(i)<0){
        pr += numbers(i)
      }*/
      val temp = numbers(i)
      temp match{
        case temp if temp >0  => sum += temp
        case temp if temp <0 => pr += temp
      }
    }
    val value:String = sum.sum.toString + "," +  pr.foldLeft(1)((m: Int, n: Int) => m * n)
    value
  }

  /**
    * This function check List numbers or not!
    * @param value
    * @return -result
    */
  def checkIfList(value:List[Int]):String={
    @tailrec
    def addValue(list:List[Int],res:String,index:Int):String={
      index<list.size match{
        case true => addValue(list,res+ " " + list(index),index+1)
        case false => res
      }
    }
    addValue(value,"",0)
  }

  /**
    * This function make numbers or number to string!
    * @param num
    * @return - string value
    */
  def toStr(num:Any): String ={
    num match{
      case value:Int => value.toString
      case value:List[Int] => checkIfList(value)
      case _ => "Не подходит!"
    }
  }
}