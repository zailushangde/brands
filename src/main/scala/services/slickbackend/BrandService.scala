package services.slickbackend

import models.Brand

import scala.concurrent.ExecutionContext

class BrandService(val databaseProvider: DatabaseProvider,
                   val dataModel: DataModel)(implicit executionContext: ExecutionContext) {

  import databaseProvider._
  import databaseProvider.driver.api._

  val brands = dataModel.brands

  def getBrands() = db.run(brands.result)

  def getBrandByCode(code: String) = db.run(brands.filter(_.brandCode === code).result.headOption)

  def createBrand(brand: Brand) = db.run(brands returning brands += brand)
}
