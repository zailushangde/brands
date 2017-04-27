package utils

import models.Brand
import spray.json.DefaultJsonProtocol

trait JsonMappings extends DefaultJsonProtocol {
  implicit val brandFormat = jsonFormat8(Brand)
}
