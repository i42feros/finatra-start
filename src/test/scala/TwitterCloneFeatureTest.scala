
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

  "Missing message field" in {
    server.httpPost(
      path = "/tweet",
      postBody = """
         {
          "location": {
            "lat": "37.7821120598956",
            "long": "-122.400612831116"
          },
          "nsfw": false
        }""",
        andExpect = BadRequest
    )
  }

  "Invalid fields" in {
    server.httpPost(
      path = "/tweet",
      postBody = """
         {
          "message": "",
          "location": {
            "lat": "9999.0",
            "long": "-122.400612831116"
          },
          "nsfw": false
        }""",
      andExpect = BadRequest
    )
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
