package org.knoldus.repo

import org.knoldus.bootstrap.usermanagement.model.{Category, User}
import org.knoldus.bootstrap.usermanagement.repo.UserRepository
import org.scalatest.flatspec.AnyFlatSpec

import java.util.UUID
import javax.xml.validation.Validator

class TestRepo  extends  AnyFlatSpec {
val userRepository= new UserRepository
  val user1=User(None,"Shekhar",Category.Customer)
  val user2=User(None, "Shashi",Category.Admin)


  "add" should "return some id " in {
    val result:Option[UUID] = userRepository.add(user1)
    assert(Some(result).nonEmpty)
  }

  "alluser" should "return all user" in {
    userRepository.add(user1)
    val result : List[User]= userRepository.getAll
    assert(result.nonEmpty)
  }

  it should "return the empty List if no user is there " in{
    val result:List[User]=userRepository.getAll
    assert(result.isEmpty)
  }

  "update" should "return true" in {
    val userId1 = userRepository.add(user1)
    val userId2 = userRepository.add(user2)
    val result: Boolean = userRepository.update(userId2, user2.copy(name = "Spyshekhu"))
    assert(result)
  }
  "delete" should "returns true" in {
    val newId1 = userRepository.add(user1)
    val newId2 = userRepository.add(user2)
    val result: Boolean = userRepository.delete(newId1)
    assert(result)
  }
  "getAll" should "returns true" in {
    val userId1 = userRepository.add(user1)
    val userId2 = userRepository.add(user2)
    val result: List[User] = userRepository.getAll
    assert(result.nonEmpty)
  }
  it should "return the empty List if no user is there " in{
    val result:List[User]=userRepository.getAll
    assert(result.isEmpty)
  }


}
