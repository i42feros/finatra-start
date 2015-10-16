package domain

case class Tweet(text: String, location: Option[Location], nsfw: Boolean = false)

