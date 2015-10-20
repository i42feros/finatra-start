package domain.http

import com.twitter.finatra.validation._
import domain.Location

case class TweetLocation(
  @Range(min = -90, max = 90) lat: Double,
  @Range(min = -180, max = 180) long: Double) {

  def toDomain = {
    Location(lat, long)
  }
}
