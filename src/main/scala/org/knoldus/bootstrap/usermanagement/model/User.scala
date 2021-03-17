package org.knoldus.bootstrap.usermanagement.model

import java.util.UUID

case class User(id:Option[UUID],name:String,category:Category)
