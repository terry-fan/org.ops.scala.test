package scala.collection

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class MapSpec extends FlatSpec with ShouldMatchers
//with ProxyMockFactory with MockFactory with ShouldMatchers
{
  "Map" should " work..." in
  {
    var testSample = scala.collection.Map.empty[String, String]
    testSample += ("A" -> "0")
    testSample += ("B" -> "1")
    testSample += ("C" -> "2")
    testSample += ("D" -> "3")
    testSample += ("E" -> "4")
    testSample += ("F" -> "5")

    val resultOfFilter = testSample.filter(e => {
      e._2 == "2" || e._2 == "4"
    }
    )
    resultOfFilter.size should be (2)

    testSample.foreach(e => {
      println(e)
    })

    println(resultOfFilter)
  }
}
