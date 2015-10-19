maven_layout()

target(name='twitter-clone',
  dependencies=[
    'finatra-start/src/main/scala'
  ]
)

target(name='tests',
  dependencies=[
    'finatra-start/src/test/scala'
  ]
)

jvm_binary(
  name='bin',
  basename='scala-finatra',
  main='TwitterCloneServerMain',
  dependencies=[
    ':twitter-clone'
  ],
  excludes=[
    exclude('org.slf4j', 'slf4j-jdk14'),
    exclude('log4j', 'log4j')
  ]
)