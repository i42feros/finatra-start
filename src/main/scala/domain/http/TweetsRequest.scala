package domain.http

import com.twitter.finatra.request.QueryParam
import com.twitter.finatra.validation._

case class TweetsRequest(
  @Max(100) @QueryParam max: Int)
