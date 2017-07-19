import scala.annotation.tailrec

/**
  * Created by Administrator on 18/07/2017.
  */
object Main {

  type LongFormat = String
  type ShortFormat = String


  val shortList: List[ShortFormat] = List(" ","thousand","million,","billion,",
    "trillion,","quadrillion,","quintillion,","sextillion,")
  val longList: List[LongFormat] = List(" ","thousand","million,","milliard,",
    "billion,","billiard,","trillion,","trilliard,")

  val shortFormat: Int =>String = (index: Int) =>  shortList(index)

  val longFormat: Int => String = (index: Int) =>  longList(index)


  def main(args: Array[String]): Unit = {
    val num = getInput()
    println("Short format is: " + getFormat(num)(shortFormat))
    println("Long format is: " + getFormat(num)(longFormat))
  }

  @tailrec
  def getInput(): BigInt = {

    println("please input a number: ")

    val input = util.Try(BigInt(readLine()))

    input match {
      case util.Success(v) => v
      case util.Failure(e) =>
        println("Error invalid value")
        getInput()
    }
  }

  def getFormat(num: BigInt)(format: Int=>String): String ={
    if(num.toString.length<=(shortList.length*3)) {
      val orderedNumber = num.toString.reverse.grouped(3).toList
      val len = orderedNumber.length - 1

      orderedNumber.reverse.zipWithIndex.map{case (x,y) => {
        val resString = x.reverse
        if(resString!="000") {
          val resFormat = format(len - y)
          s"${resString.replaceFirst("^0+(?!$)","")} $resFormat "
        }else{
          ""
        }
      }}.mkString("").trim

    }else{
      "Sorry Index out of range"
    }
  }

}
