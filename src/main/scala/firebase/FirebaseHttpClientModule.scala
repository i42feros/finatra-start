package firebase

import org.joda.time.Duration

import com.twitter.finatra.httpclient.modules.HttpClientModule
import com.twitter.finatra.utils.RetryPolicyUtils._


class FirebaseHttpClientModule extends HttpClientModule {
  override val dest = "flag!firebase"

  override def retryPolicy = Some(exponentialRetry(
  start = Duration.millis(10L),
  multiplier =2,
  numRetries = 3,
  shouldRetry = Http4xxOr5xxResponses
  ))
}
