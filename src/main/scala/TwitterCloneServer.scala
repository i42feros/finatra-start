import com.twitter.finagle.httpx.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import controllers.TweetsController
import firebase.FirebaseHttpClientModule
import warmup.TwitterCloneWarmup

object TwitterCloneServerMain extends TwitterCloneServer

class TwitterCloneServer extends HttpServer {
  override def modules = Seq(FirebaseHttpClientModule)

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[TweetsController]
  }

  override def warmup() {
    run[TwitterCloneWarmup]()
  }

}
