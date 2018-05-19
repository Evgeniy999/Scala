import scala.annotation.tailrec
import scala.io.StdIn

/**
  *
  * @author Evgeniy
  * @version 0.1
  */
object Demo {
  def main(args: Array[String]): Unit = {
    val numbers = List[Int](1, 2, 5, 7, 11, 15, 14, 16, 17, 19, 21, 213, 124, 0)
    print("Введите число:")
    val number: Int = StdIn.readInt()
    print("Введите степень:")
    val mul: Int = StdIn.readInt()
    println("Без хвостовой рекурсии:" + degreeOfNumber(number,mul))
    println("C хвостовой рекурсии:" +degreeOfNumberTail(number,mul,1))
    println("Проверка чисел на простое число:")
    showPrimes(numbers)
    println("С хвостовой рекурсией:")
    showPrimesTail(numbers)
  }

  /**
    * Input data
    * @param number - number
    * @param mul - degree
    * @return - result
    */
  def degreeOfNumber(number: Int, mul: Int): Int=
    if (mul == 0) 1
    else if (mul < 0) degreeOfNumber(number, mul + 1) / number
    else number * degreeOfNumber(number, mul - 1)

  /**
    * Method  - number raised to the power of the method
    * Input data:
    * @param number - number
    * @param mul - degree
    * @param acc - a new local variable that stores the intermediate results
    * @return
    */
  @tailrec
  def degreeOfNumberTail(number:Int,mul:Int, acc: Int): Int =
    if(mul == 0) acc
    else if(mul<0) degreeOfNumberTail(number,mul+1,acc/number)
    else degreeOfNumberTail(number,mul-1,acc*number)

  /**
    * Check the number by a prime number
    * Input data:
    * @param num - data-in
    * @return - true or false
    */
 def isPrimeTailRec(num: Int): Boolean = {
   @tailrec
   def isPrimeRec(num: Int, i: Int): Boolean = {
     (num % i != 0) && ((i * i > num) || isPrimeRec(num, i + 1))
   }
   (num == 2) || (num > 2) && isPrimeRec(num, 2)
 }

  /**
    * Input data:
    * @param num - data-in
    * @return - true of false
    */
  def isPrime(num: Int): Boolean = {
    !(2 to num / 2).exists(num % _ == 0) && (num >= 2)
  }

  /**
    * Output data from List
    * @param numbers - data-in
    */
  def showPrimesTail(numbers:List[Int]):Unit= {
    for (i <- 0 to numbers.length - 1) {
      print(numbers(i) + "- ")
      println(isPrimeTailRec(numbers(i)))
    }
  }

  def showPrimes(numbers:List[Int]):Unit= {
    for (i <- 0 to numbers.length - 1) {
      print(numbers(i) + "- ")
      println(isPrime(numbers(i)))
    }
  }

}
