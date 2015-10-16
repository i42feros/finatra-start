
import com.twitter.finatra.http.test.{EmbeddedHttpServer, HttpTest}
import com.twitter.inject.Mockito
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.httpx.Status._


class TwitterCloneFeatureTest extends FeatureTest with Mockito with HttpTest {
  override val server = new EmbeddedHttpServer(new TwitterCloneServer)

  "Post tweet" in {
    server.httpPost(
      path = "/tweet",
      postBody = """
        {
          "message": "Hello world",
          "location": {
            "lat": "37.7821120598956",
            "long": "-122.400612831116"
          },
          "nsfw": false
        }""",
      andExpect = Created,
      withLocation = "/tweet/123",
      withJsonBody = """
        {
          "id": "123",
          "message": "Hello world",
          "location": {
            "lat": "37.7821120598956",
            "long": "-122.400612831116"
          },
          "nsfw": false
        }""")
  }

  "Server" should {
    "Say hi" in {
      server.httpGet(
        path = "/hi",
        andExpect = Ok,
        withBody = "Hello world")
    }
  }
}
