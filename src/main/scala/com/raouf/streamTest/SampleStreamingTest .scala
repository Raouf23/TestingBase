package com.raouf.streamTest

import com.holdenkarau.spark.testing.StreamingSuiteBase
import org.scalatest.FunSuite
import org.apache.spark.streaming.dstream.DStream

class SampleStreamingTest extends FunSuite with StreamingSuiteBase {
  test("really simple transformation") {
    val input = List(List("hi"), List("hi holden"), List("bye"))
    val expected = List(List("hi"), List("hi", "holden"), List("bye"))
    testOperation[String, String](input, tokenize _, expected, ordered = false)
  }
  
  def tokenize(f: DStream[String]): DStream[String] = {
    f.flatMap(_.split(" "))
  }
}