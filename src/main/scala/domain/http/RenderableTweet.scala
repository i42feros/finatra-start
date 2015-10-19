package domain.http

import domain.{TweetId, Tweet}

case class RenderableTweet(
  id: TweetId,
  message: String,
  location: Option[RenderableLocation],
  nsfw: Boolean)

object RenderableTweet {
  def fromDomain(id: TweetId, tweet: Tweet) =
    RenderableTweet(
    id = id,
    message = tweet.message,
    location = tweet.location map {RenderableLocation.fromDomain},
    nsfw = tweet.nsfw
  )
}
