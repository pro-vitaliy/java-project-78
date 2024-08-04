setup:
	./gradlew wrapper --gradle-version 8.7

build:
	./gradlew clean build

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

install-dist:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app