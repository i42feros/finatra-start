package domain.http

import domain.TweetId
import com.twitter.finatra.request.RouteParam

case class TweetGetRequest (
  @RouteParam id: TweetId)
