package services

import akka.http.scaladsl.server.Directives._
import spray.json._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import models._
import services.slickbackend.BrandService
import utils.JsonMappings

import scala.concurrent.ExecutionContext.Implicits.global

class BrandRouter(brandService: BrandService) extends JsonMappings {
  import brandService._
  val brandsApi =
    (path("brands") & get) {
      complete(getBrands().map(_.toJson))
    } ~
    (path("brands") & post) { entity(as[Brand]) { brand =>
      complete(createBrand(brand).map(_.toJson))
    }} ~
    (path("brands"/Segment) & get) { code =>
      complete(getBrandByCode(code).map(_.toJson))
    }
}
