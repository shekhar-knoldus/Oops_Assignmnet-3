package org.knoldus.model

import org.knoldus.bootstrap.usermanagement.model.{Category, User, UserManagement}
import org.knoldus.bootstrap.usermanagement.repo.UserRepository
import org.scalatest.flatspec.AnyFlatSpec

import java.util.UUID

class TestUser extends AnyFlatSpec{
  val userRepository= new UserRepository
  val user1=User(None,"Shekhar",Category.Customer)
  val user2=User(None, "Shashi",Category.Admin)
  val userManagement=new UserManagement(userRepository)

  "add" should "return some id " in {
    val result:Option[UUID] = userRepository.add(user1)
    assert(Some(result).nonEmpty)
  }
  it should "throw RunTimeException " in {
    assertThrows[RuntimeException]{
      userManagement.add(user1.copy(id=Some(UUID.randomUUID())))
    }
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
  it should "throw RunTimeException " in {
    assertThrows[RuntimeException]{
      userManagement.add(user1.copy(id=Some(UUID.randomUUID())))
    }
  }

  "delete" should "returns true" in {
    val newId1 = userRepository.add(user1)
    val newId2 = userRepository.add(user2)
    val result: Boolean = userRepository.delete(newId1)
    assert(result)
  }
  it should "throw RunTimeException " in {
    assertThrows[RuntimeException]{
      userManagement.add(user1.copy(id=Some(UUID.randomUUID())))
    }
  }

  "getAll" should "returns true" in {
    val userId1 = userRepository.add(user1)
    val userId2 = userRepository.add(user2)
    val result: List[User] = userRepository.getAll
    assert(result.nonEmpty)
  }
  it should "throw RunTimeException " in {
    assertThrows[RuntimeException]{
      userManagement.add(user1.copy(id=Some(UUID.randomUUID())))
    }
  }
  it should "return the empty List if no user is there " in{
    val result:List[User]=userRepository.getAll
    assert(result.isEmpty)
  }
}
