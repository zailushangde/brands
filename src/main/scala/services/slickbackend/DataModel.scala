package services.slickbackend

import models.Brand
import slick.lifted.ProvenShape

class DataModel(val databaseProvider: DatabaseProvider) {

  import databaseProvider.driver.api._

  class BrandTable(tag: Tag) extends Table[Brand](tag, "brand") {
    def brandCode = column[String]("brand_code", O.PrimaryKey)
    def name = column[String]("name")
    def ownBrand = column[Boolean]("own_brand")
    def url = column[Option[String]]("url")
    def brandFamilyCode = column[Option[String]]("brand_family_code")
    def mediaCode = column[Option[String]]("media_code")
    def misspelled = column[Option[String]]("misspelled")
    def countryOfOrigin = column[Option[String]]("country_of_origin")

    def * : ProvenShape[Brand] = (brandCode, name, ownBrand, url, brandFamilyCode, mediaCode, misspelled, countryOfOrigin) <> ((Brand.apply _).tupled, Brand.unapply)
  }

  val brands = TableQuery[BrandTable]
}
