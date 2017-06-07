package com.raouf.streamTest

import org.scalatest.FunSuite
import com.holdenkarau.spark.testing.StreamingSuiteBase
import org.apache.spark.streaming.dstream.DStream

class timeoutTest extends FunSuite with StreamingSuiteBase {
  override def maxWaitTimeMillis:Int =20000
  
  test("Increase duration more than 10 seconds")
  {
    val input  =(1 to 1000).toList.map(x =>List(x))
    val expected =(1 to 1000).toList.map(x =>List(x*2))
    testOperation(input,multiply _, expected ,ordered=false)
    
    def multiply(ds:DStream[Int]):DStream[Int]={
      ds.map(_ *2)
    }
  }
}