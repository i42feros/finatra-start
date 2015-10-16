import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.Mockito
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.httpx.Status.Created


class TwitterCloneFeatureTest extends FeatureTest with Mockito {
  val server = new EmbeddedHttpServer(
    twitterServer = new HttpServer {})

  "Post tweet" in {
    server.httpPost(
      path = "/tweet",
      postBody = """
          {
            "message": "Hello #SFScala", 
            "location": { 
              "lat": "37.7821120598956", 
               "long": "-122.400612831116" 
            },
            "sensitive": false 
          }""",
      andExpect = Created,
      withLocation = "/tweet/123",
      withJsonBody = """
        { 
          "id": "123", 
          "message": "Hello #SFScala", 
          "location": { 
            "lat": "37.7821120598956", 
            "long": "-122.400612831116"
          },  
          "sensitive": false 
        }"""
    )
  }
}
