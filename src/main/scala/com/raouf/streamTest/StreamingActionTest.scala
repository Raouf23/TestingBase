package com.raouf.streamTest



import org.apache.spark.streaming.dstream.DStream
import org.scalatest.FunSuite

import com.holdenkarau.spark.testing.StreamingActionBase
import org.apache.spark.rdd.RDD
import org.apache.spark.Accumulator

class StreamingActionTest extends FunSuite with StreamingActionBase{
  test("a simple action"){
      val input = List(List("hi"), List("bye"))
    val acc = sc.accumulator(0)
    val cw = countWordsLength(acc)
    runAction(input, cw)
    assert(5 === acc.value)
  }
  
  def countWordsLength(acc:Accumulator[Int]):(DStream[String] =>Unit) ={
    def c(input:DStream[String]):Unit ={
      input.foreachRDD{r:RDD[String] =>
      r.foreach{e: String => acc += e.length()}}
    }
    c _
  }
}