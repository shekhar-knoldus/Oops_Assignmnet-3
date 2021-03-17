package org.knoldus.bootstrap

import org.knoldus.bootstrap.usermanagement.model.{Category, User, UserManagement}
import org.knoldus.bootstrap.usermanagement.repo.{Dao, UserRepository}

import java.util.UUID

object MainClass {
  def main(args: Array[String]): Unit = {

    val userRepository:Dao[User]=new UserRepository()
    val userManagement = new  UserManagement(userRepository)

    val user1=User(None,"Shekhar",Category.Customer)
    val id_1=userManagement.add(user1)
    val user2=User(None, "Shashi",Category.Admin)

    val id_2=userManagement.add(user2)
    val newId1 = userManagement.alluser(id_1).copy(name="SPY")
    userManagement.update(id_2,newId1)

    userManagement.delete(id_1)

    userManagement.getAll
  }
}

