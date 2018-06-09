
kotlinc \
  src/Database.kt \
  src/exceptions/*.kt \
  src/statements/*.kt \
  -include-runtime \
  -d db.jar