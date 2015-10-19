package controllers

import javax.inject.{Inject, Singleton}

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller
import domain.Tweet
import domain.http.RenderableTweet
import services.TweetsService

@Singleton
class TweetsController @Inject()(
  tweetsService: TweetsService)
  extends Controller {

  post("/tweet") { postedTweet: Tweet =>
    tweetsService.save(postedTweet) map { renderableTweet =>
      response
        .created(renderableTweet)
        .location(renderableTweet.id)
    }

  }

  get("/hi") { request: Request =>
    "Hello world"
  }
}
