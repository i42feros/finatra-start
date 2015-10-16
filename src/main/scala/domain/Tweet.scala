package domain

case class Tweet(message: String, location: Option[Location], nsfw: Boolean = false)

