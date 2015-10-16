package controllers

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller
import domain.Tweet
import domain.http.{TweetResponse, TweetPostRequest}

class TweetsController extends Controller {
  post("/tweet") { postedTweet: Request =>
    response.created("hello").location("/tweet/123")
  }

  get("/hi") { request: Request =>
    "Hello world"
  }
}
