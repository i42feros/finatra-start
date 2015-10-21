maven_layout()

target(name='finatra-start',
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
  basename='finatra-start',
  main='TwitterCloneServerMain',
  dependencies=[
    ':finatra-start'
  ],
  excludes=[
    exclude('org.slf4j', 'slf4j-jdk14'),
    exclude('log4j', 'log4j')
  ]
)