# Finatra
Following Finatra tutorial (but using finatra 2.1.0), including:
- Finagle
- Twitter Server


From the top-level of the finatra-start directory, run:

```sbt "project finatra-start" "run -firebase.host=finatra.firebaseio.com -com.twitter.server.resolverMap=firebase=finatra.firebaseio.com:443"```

- To add a new tweet you can run in a terminal something like:
```curl -H "Content-Type: application/json" -X POST -d '{"message": "Hello world","location":{"lat": "37.7821120598956","long": "-122.400612831116"},"nsfw":false}' http://127.0.0.1:8888/tweet```
- To see the tweet inserted go to: http://127.0.0.1:8888/tweet/04fa10f9-8188-4bd2-b4e0-46fd09b77aa9
- Or view the twitter-server admin interface: http://localhost:9990/admin 


References:
- https://www.youtube.com/watch?v=hkVp9W4c9bs
- http://twitter.github.io/finatra/assets/FinatraSFScala.pdf
- https://github.com/twitter/finatra/tree/master/examples/twitter-clone