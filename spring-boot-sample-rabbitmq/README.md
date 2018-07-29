
# Producer Consumer example using RabbitMq and Spring-Boot
To test it, you need to have rabbitMq installed and also Postman.

The example is based on sending an object defined in a common message library from producer to consumer, using a POST request from a REST endpoint.

Below are the steps for setting up and running the environment.

## Deploy message-library to local .m2 repo
```
mvn install message-library
```
## Start producer
inside producer project: 
```
mvn spring-boot:run
```
## Start consumer
inside consumer project: 
```
mvn spring-boot:run
```
## Open PostMan and POST a message on http://localhost:8182/send having the body application/json:
```
{
"id": "someId",
"commandSpecificId": "someSpecificId"
}
```
Inside consumer console you will see a message that the SpecificCommand was received.
