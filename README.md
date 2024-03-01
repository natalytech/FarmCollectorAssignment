# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

create planted example: 

`curl -X POST \
  http://localhost:8080/v1/data-collector/planted \
  -H 'Content-Type: application/json' \
  -d '{
    "fieldId": "field_id_1",
    "plantingArea": 10.5,
    "cropType": "corn",
    "expectedProductAmount": 20.3,
    "season": "SUMMER"
}'`

create harvested example using <planted_id> parameter from prev call
`curl -X POST \
  http://localhost:8080/v1/data-collector/harvested \
  -H 'Content-Type: application/json' \
  -d '{
    "fieldId": "field_id_1",
    "plantedId": "<planted_id>",
    "actualHarvestAmount": 15.7
}'`

get report for farms:
`curl -X GET \
http://localhost:8080/v1/report/farm \
-H 'Content-Type: application/json'`