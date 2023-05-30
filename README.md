# spring-boot-kafka-demo
> spring-boot integration kafka test ...

## help
* docker-compose up -d
```shell
docker exec -it kafka bash
kafka-console-producer.sh --topic datas --bootstrap-server localhost:9092
kafka-console-consumer.sh --topic datas --bootstrap-server localhost:9092
```

## reference link
* https://kafka.apache.org/
* https://kafka.apache.org/documentation/
* https://github.com/spring-projects/spring-kafka
* https://docs.spring.io/spring-kafka/docs/2.8.9/reference/html/
* https://github.com/cdimascio/dotenv-java