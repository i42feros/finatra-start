package domain

import com.twitter.finatra.validation.Size

case class Tweet(
  @Size(min = 1, max = 140)message: String,
  location: Option[Location],
  nsfw: Boolean = false)

