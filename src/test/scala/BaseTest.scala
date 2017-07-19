import java.io.{ByteArrayInputStream, StringBufferInputStream}

import Main._
import org.scalatest.{FlatSpec, Matchers}

import scala.Console.setIn

/**
  * Created by Administrator on 18/07/2017.
  */


class BaseTest extends FlatSpec with Matchers {
  "short number format" should "return 1 million, 235 thousand and 698" in {
    val number = 1235698
    getFormat(number)(shortFormat) should be ("1 million, 235 thousand 698")
  }

  it should "return 100 if 100 is fed in" in {
    val number = 100
    getFormat(number)(shortFormat) should be ("100")
  }

  it should "return 1 billion, 234 million, 567 thousand and 890 for 1234567890" in {
    val number = 1234567890
    getFormat(number)(shortFormat) should be ("1 billion, 234 million, 567 thousand 890")
  }

  it should "return 1 billion, 1 if fead in 1000000001" in {
    val number = 1000000001
    getFormat(number)(shortFormat) should be ("1 billion, 1")
  }

  "long number format" should "return 1 million, 235 thousand and 698" in {
    val number = 1235698
    getFormat(number)(longFormat) should be ("1 million, 235 thousand 698")
  }

  it should "return 100 if 100 is the input" in {
    val number = 100
    getFormat(number)(longFormat) should be ("100")
  }

  it should "return 1 milliard, 234 million, 567 thousand and 890 for 1234567890" in {
    val number = 1234567890
    getFormat(number)(longFormat) should be ("1 milliard, 234 million, 567 thousand 890")
  }

  it should "return Sorry Index out of range if length is more than 25" in {
    val number = BigInt("12345678902156451231365412315646876423877246872387238")
    getFormat(number)(longFormat) should be ("Sorry Index out of range")
  }



  "longformat" should "milliard, if 1 is passed through" in {
    val number = 3
    longFormat(number) should be ("milliard,")
  }

  "shortformat" should "thousand if 3 is passed through" in {
    val number = 3
    shortFormat(number) should be ("billion,")
  }

  "get input" should "return 0 if an asd is submitted" in {
    val code = "asd"
    val in = new ByteArrayInputStream(code.getBytes("UTF-8"))
    setIn(in)

    getInput(0) should be (0)
  }

  "mian" should "should return no errors" in {
    val code = "1000000000234"
    val in = new ByteArrayInputStream(code.getBytes("UTF-8"))
    setIn(in)

    main(Array())
  }

}
