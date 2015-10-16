package domain.http

import domain.Location

case class RenderableLocation(
  lat: String,
  long: String)

object RenderableLocation {
  def fromDomain(location: Location): RenderableLocation = {
    new RenderableLocation(lat = location.lat.toString, long = location.long.toString)
  }
}