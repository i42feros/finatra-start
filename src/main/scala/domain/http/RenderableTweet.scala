package domain.http

import domain.Tweet

case class RenderableTweet(
  id: StatusId,
  message: String,
  location: Option[RenderableLocation],
  nsfw: Boolean)

object RenderableTweet {
  def fromDomain(tweet: Tweet) =
    RenderableTweet(
    id = "",
    message = tweet.message,
    location = tweet.location map {RenderableLocation.fromDomain},
    nsfw = tweet.nsfw
  )
}
