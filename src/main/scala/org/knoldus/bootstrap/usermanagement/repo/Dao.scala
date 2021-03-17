package org.knoldus.bootstrap.usermanagement.repo

import java.util.UUID

trait Dao[T] {

   def add(t:T):Option[UUID]
  def alluser(id:Option[UUID]):T
  def delete(id:Option[UUID]):Boolean
  def update(id:Option[UUID], t:T):Boolean
  def getAll:List[T]
}
