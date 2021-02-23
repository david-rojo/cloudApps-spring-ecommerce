# cloudApps-spring-ecommerce

## Launch application

```
mvn spring-boot:run
```

## Execute tests

```
mvn test
```

## H2 database

H2 console connection details:

* url: ```http://localhost:8080/h2-console```
  * Driver class: ```org.h2.Driver```
  * JDBC url: ```jdbc:h2:mem:ecommercedb;DB_CLOSE_ON_EXIT=FALSE```
  * user: ```user```
  * password: ```password```

Queries to check database information:

```
SELECT * FROM SHOPPING_CART;
SELECT * FROM CART_ITEM;
SELECT * FROM PRODUCT;
```

## Testing

You can find a file named [Practice1-ecommerce.postman_collection.json](Practice1-ecommerce.postman_collection.json) that you can import in [Postman](https://www.postman.com/), to test the implemented endpoints.

## Author

[David Rojo (@david-rojo)](https://github.com/david-rojo)
