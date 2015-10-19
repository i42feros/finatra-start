package services

import java.util.UUID
import javax.inject.Singleton

import com.twitter.util.Future
import domain.TweetId

@Singleton
class IdService {
  def getId(): Future[TweetId] = {
    Future(
      TweetId(
        UUID.randomUUID().toString))
  }
}
