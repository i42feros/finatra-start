package services

import javax.inject.{Singleton, Inject}

import com.twitter.util.Future
import domain.Tweet
import domain.http.TweetResponse

@Singleton
class TweetsService @Inject()(
 idService: IdService,
 firebase: FireBaseClient) {

  def save(postedTweet: Tweet): Future[Tweet] = {
    for {
      id <- idService.getId()
      tweet = postedTweet.toDomain(id)
      responseTweet = TweetResponse.fromDomain(tweet)
      firebasePath = firebaseUrl(tweet.id)
      _ <- firebase.put(firebasePath, responseTweet)
    } yield tweet
  }
}
