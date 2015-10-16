package domain

import com.twitter.finatra.validation.Range

case class Location(
 @Range(min = -90, max = 90) lat: Double,
 @Range(min = -180, max = 180) long: Double)
