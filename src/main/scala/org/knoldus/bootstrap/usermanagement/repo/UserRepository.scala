package org.knoldus.bootstrap.usermanagement.repo

import org.knoldus.bootstrap.usermanagement.model.User

import java.util.UUID
import scala.collection.mutable.ListBuffer

 class UserRepository  extends  Dao[User] {

  private val listBuffer=ListBuffer.empty[User]

  override def add(user:User):Option[UUID] ={

   val userid=UUID.randomUUID()
   user match {
    case User(_, _,_) =>listBuffer.append(user.copy(id=Some(userid))); listBuffer.last.id
    case User(Some(_),_,_)=>null
   }
 }

  override def alluser(id:Option[UUID]):User = {
   val newList = listBuffer.filter(user =>{ user.id == id})
   newList.head
  }
   override def delete(id :Option[UUID]):Boolean= {
    val index = listBuffer.indexOf(alluser(id))
    if (listBuffer.isEmpty) {
     false
    }
    else {
    listBuffer.remove(index)
    true
   }
   }
     override def update(id:Option[UUID],newUser: User):Boolean={
    val index=listBuffer.indexOf(alluser(id))
     if(index==null)
      {
       false
      }
     else
      {
      listBuffer.update(index, newUser)
      true
     }
   }

   override def getAll:List[User]=listBuffer.toList


 }
