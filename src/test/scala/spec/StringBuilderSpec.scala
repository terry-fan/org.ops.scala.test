package scala.collection

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory


class StringBuilderSpec extends FlatSpec with ShouldMatchers
{
  "StringBuilder" should "LastIndexOf" in
  {
    val buf = new StringBuilder("https://abc.com.tw// ")

    println(buf.lastIndexOf('t', buf.length - 1))
    println(buf.lastIndexWhere( (value) => value != '/' && value !=' '))
    println(buf.lastIndexWhere( (value) => value == 'x'))


    assert(true)
  }
}
