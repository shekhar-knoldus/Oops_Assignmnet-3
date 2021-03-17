package org.knoldus.bootstrap.usermanagement.model

import org.knoldus.bootstrap.usermanagement.repo.Dao

import java.util.UUID

class UserManagement(userRepository: Dao[User]) {


  def add(user: User): Option[UUID] = {
  if(user.id.isDefined)
    {
    userRepository.add(user)
    }
   else
   {
    None
   }
  }
  def alluser(id:Option[UUID]): User= {
    userRepository.alluser(id)
  }
  def update(id:Option[UUID],newUser: User):Boolean = {
  userRepository.update(id,newUser)
  }
  def delete(id:Option[UUID]):Unit = {
    userRepository.delete(id)
  }

  def getAll : List[User]={

    if(userRepository.getAll.isEmpty)
      {
        List.empty
      }
    else {
      userRepository.getAll
    }

  }

}
