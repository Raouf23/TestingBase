package com.raouf.streamTest

import org.scalatest.FunSuite
import com.holdenkarau.spark.testing.StreamingSuiteBase
import org.apache.spark.streaming.dstream.DStream

class EmptyBatchTest extends FunSuite with StreamingSuiteBase{
  def multiply(stream1:DStream[Int]) = stream1.map(_ *3)
  test("empty batch by using null"){
      val input1 = List(List(1),null,List(10))
      val output = List(List(3),List(30))
      
      testOperation(input1, multiply _, output, ordered =false)
  }
}