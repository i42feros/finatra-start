package firebase

import com.twitter.finatra.httpclient.modules.HttpClientModule

class FirebaseHttpClientModule extends HttpClientModule {
  override def dest: String = "flag!firebase"

//  override def retryPolicy = Some(RetryPolicyUtils.exponentialRetry[Http4xx0r5xxResponses](
//    start = 10.millis
//    multiplier = 2,
//    numRetries = 3,
//    shouldRetry = Http4xx0r5xxResponses
//  ))
}
