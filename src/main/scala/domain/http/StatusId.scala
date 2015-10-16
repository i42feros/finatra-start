package domain.http

import com.twitter.finatra.domain.WrappedValue

case class StatusId(val id: String) extends WrappedValue[String]
