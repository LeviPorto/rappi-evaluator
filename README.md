# RAPPI-EVALUATOR

## Motivation

To isolate all entities that is important to evaluate restaurants, rappi-evaluator was 
created. Considering that evaluation requests (save and retrieve of ratings) are 
frequently and important to users, i saw necessity of create that micro-service, 
because of the quantity of requests (we can scale horizontally, creating many 
instances of it). Also, this micro-service uses NO-SQL database to find faster the 
information, instead of has more trustworthy data

# Domain

There are two entities: Rating (most important) and Suggested Restaurant (less important). 
Rating was created to user evaluate order´s restaurant and API calculate average of 
restaurant, based on its orders. Suggested Restaurant was created to user suggest any 
restaurant and Rappi people can make decisions of publicity based on it.

# Architecture and Technologies

rappi-evaluator is a micro-service, that is discovered by Eureka, to communicate with 
others micro-services. Made in Kotlin, using functional programming to clean code and 
make more predictable, feign to communicate with others micro-services, kafka to produce 
messages, redis to cache, cassandra to store data. Also, was created using Zomato API to 
get world restaurants. This micro-service uses event-driven pattern to communicate with others 
micro-services

# Flux

Base end point is {host}/evaluator/. To test, we considering localhost.
 
* We can send POST on /rating, passing rating entity in a body (see a code) - 
that calculate, in real time, using kafka to send rating events (event-sourcing), 
restaurant rating
* We can find by restaurant, send GET rating/restaurant/{restaurantId}.
* We can send POST on /suggestedRestaurant, passing suggestedRestaurant entity in a 
body (see a code) - this create one suggested restaurant if doesn´t exist or increment 
count if exists.
* We can send GET on /suggestedRestaurant/zomatoSearch, passing user-key in header, 
search_type and searched_name in parameters - this retrieve all restaurants from that type (according to Zomato API) and that name

# Dependencies

* RAPPI-EUREKA
* RAPPI-CONFIG
* RAPPI-MANAGER
* Redis
* Kafka
* Cassandra


