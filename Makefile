.DEFAULT_GOAL=help

.PHONY: docker

build: # Build the jar
	mvn clean package -Dmaven.test.skip

docker-up: build # docker-compose up command
	docker-compose -f docker-compose.yaml -p warehouse up -d

test: docker-up # Run tests
	mvn test

docker-down: # docker-compose down command
	docker-compose -f docker-compose.yaml -p warehouse down

help: # Show this help
	@egrep -h '\s#\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?# "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'



