package org.javainterop

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class MapSpec extends FlatSpec with ShouldMatchers
//with ProxyMockFactory with MockFactory with ShouldMatchers
{
  "JavaInterop" should " invoke static function in Java" in
  {
    val encoded = org.apache.commons.codec.binary.Base64.encodeBase64String("ABC".getBytes("UTF-8"))
    println(encoded)

    assert(true)
  }
}
