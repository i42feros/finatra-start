package domain

import com.twitter.finatra.domain.WrappedValue

case class TweetId(val id: String) extends WrappedValue[String]
