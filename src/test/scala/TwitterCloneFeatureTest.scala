
import com.google.inject.testing.fieldbinder.Bind
import com.twitter.finatra.http.test.{EmbeddedHttpServer, HttpTest}
import com.twitter.inject.Mockito
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.httpx.Status._
import com.twitter.util.Future
import domain.{Location, Tweet, TweetId}
import domain.http.RenderableTweet
import firebase.FirebaseClient
import services.IdService



class TwitterCloneFeatureTest extends FeatureTest with Mockito {
  override  val server = new EmbeddedHttpServer(
    twitterServer = new TwitterCloneServer {
      override val overrideModules = Seq(integrationTestModule)
    }
  )

  @Bind val firebaseClient = smartMock[FirebaseClient]
  @Bind val idService = smartMock[IdService]

  "Post tweet" in {
    val tweetId = TweetId("123")
    idService.getId returns Future(tweetId)

    val tweet: Tweet = new Tweet("Hello world", Some(new Location(37.7821120598956d, -122.400612831116d)), false)

    val putTweet = RenderableTweet.fromDomain(tweetId, tweet)
    firebaseClient.put("/tweets/123.json", putTweet) returns Future.Unit

    val result = server.httpPost(
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
