package firebase


import com.twitter.finatra.conversions.time._
import com.twitter.finatra.httpclient.modules.HttpClientModule
import com.twitter.finatra.utils.RetryPolicyUtils._


object FirebaseHttpClientModule extends HttpClientModule {

  override val dest = "flag!firebase"

  override def retryPolicy = Some(exponentialRetry(
  start = 10.millis,
  multiplier = 2,
  numRetries = 3,
  shouldRetry = Http4xxOr5xxResponses
  ))

}
