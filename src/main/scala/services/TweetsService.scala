package services

import javax.inject.{Singleton, Inject}

import com.twitter.util.Future
import domain.{TweetId, Tweet}
import domain.http.{RenderableTweet, TweetResponse}
import firebase.FirebaseClient

@Singleton
class TweetsService @Inject()(
 idService: IdService,
 firebase: FirebaseClient) {

  def save(postedTweet: Tweet): Future[RenderableTweet] = {
    for {
      id <- idService.getId()
      renderableTweet = RenderableTweet.fromDomain(id, postedTweet)
      firebasePath = firebaseUrl(renderableTweet.id)
      _ <- firebase.put(firebasePath, renderableTweet)
    } yield renderableTweet
  }

  private def firebaseUrl(tweetId: TweetId): String = {
    s"/tweets/${tweetId.id }.json"
  }
}
