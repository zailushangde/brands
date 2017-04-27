package models

case class Brand(brandCode: String, name: String, ownBrand: Boolean, url: Option[String],
                 brandFamilyCode: Option[String], mediaCode: Option[String], misspelled: Option[String],
                 countryOfOrigin: Option[String])


