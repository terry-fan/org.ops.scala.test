package org.test.jackson

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class JacksonSpec extends FlatSpec with ShouldMatchers
{
  import com.fasterxml.jackson.databind.ObjectMapper

  "Mapper" should "serialize object" in
  {
    val map = new java.util.LinkedHashMap[String, Any]

    map.put("name", 123)
    map.put("name2", 456)

    val mapper = new ObjectMapper
    println(mapper.writeValueAsString(map))

    assert(true)
  }

}
