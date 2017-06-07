package com.raouf.streamTest

import org.scalatest.FunSuite
import com.holdenkarau.spark.testing.StreamingSuiteBase
import org.apache.spark.streaming.dstream.DStream

class StreamingCountTest extends FunSuite with StreamingSuiteBase{
  
  test("Word Count Test"){
    val input = List(List("the is word the"))
    val expected = List(List(("the",2),("word",1),("is",1)))
    testOperation(input,count _, expected,ordered =false)
  }
  
  def count(lines:DStream[String]):DStream[(String,Int)]={
    lines.flatMap(_.split(" ")).map(x =>(x,1)).reduceByKey(_ + _)
  }
}