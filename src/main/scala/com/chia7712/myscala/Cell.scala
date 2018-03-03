package com.chia7712.myscala

import org.apache.hadoop.hbase.{CellBuilderFactory, CellBuilderType}
import org.apache.hadoop.hbase.util.Bytes

trait Cell extends Ordered[Cell] {
  def key:Key
  def value:Array[Byte]
  override def equals(obj: scala.Any) = {
    obj match {
      case that:Cell => compare(that) == 0
      case _ => false
    }
  }
  override def compare(that:Cell) = key.compare(that.key)
  override def toString = key.toString + "/" + Bytes.toStringBinary(value)
}
object Cell {
  def apply(k:Key, v:Array[Byte]) = {
    new Cell() {
      override def key = k
      override def value = v
    }
  }
}