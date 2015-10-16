package controllers

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller
import domain.Tweet
import domain.http.{RenderableTweet, StatusId, TweetResponse, TweetPostRequest}

class TweetsController extends Controller {
  post("/tweet") { postedTweet: Tweet =>
    val statusId = StatusId("123")

    // Save status here
    val renderableTweet = RenderableTweet.fromDomain(postedTweet, statusId)
    response
      .created(renderableTweet)
      .location(renderableTweet.id)
  }

  get("/hi") { request: Request =>
    "Hello world"
  }
}
