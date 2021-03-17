package org.knoldus.bootstrap.usermanagement.model

 sealed trait Category

   object Category
  {
    case object Customer extends Category
    case object Admin  extends  Category
  }
