package domain.http

import domain.{Location, TweetId, Tweet}


case class TweetResponse(
                          message: String,
                          location: Option[TweetLocation],
                          nsfw: Boolean) {

  def toDomain = {
    Tweet(
      message,
      location map { _.toDomain },
      nsfw)
  }
}
