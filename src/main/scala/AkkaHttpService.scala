import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import services.BrandRouter
import services.slickbackend.{BrandService, DataModel, DatabaseProvider}
import utils.Config

import scala.concurrent.ExecutionContext

object AkkaHttpService extends App with Config{
  implicit val actorSystem = ActorSystem()
  implicit val executor: ExecutionContext = actorSystem.dispatcher
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val databaseProvider = new DatabaseProvider(jdbcUrl, dbUser, dbPassword)
  val dataModel = new DataModel(databaseProvider)
  val brandService = new BrandService(databaseProvider, dataModel)
  val brandRouter = new BrandRouter(brandService)
  val routers = pathPrefix("api")(brandRouter.brandsApi)

  Http().bindAndHandle(routers, httpHost, httpPort)
}
