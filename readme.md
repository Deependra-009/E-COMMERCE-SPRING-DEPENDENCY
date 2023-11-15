# E-Commerce Services Dependency 

## Overview

This repository contains two services for an e-commerce application based on the Spring framework. These services provide functionality related to the user's cart and wishlist.

## Steps are given below to install dependency for `gradle` or `maven`

### If you have any doubt or find a bug so don't hesitate contact to me because it help me to improve this dependency
Email:  deeputrivedi0409@gmail.com 

## Services

### 1. CartService

The `CartService` is responsible for managing the user's shopping cart. It offers the following functionalities:

- **addProductInCart(userId, productId, quantity):**
  - Adds a product to the user's cart with the specified quantity.

- **increaseProductQuantityInCartByOne(userId, productId):**
  - Increases the quantity of a specific product in the user's cart by one.

- **decreaseProductQuantityInCartByOne(userId, productId):**
  - Decreases the quantity of a specific product in the user's cart by one.

- **setProductQuantityInCartByNumber(userId, productId, quantity):**
  - Sets the quantity of a specific product in the user's cart to a specified number.

- **clearAllProductFromCart(userId):**
  - Removes all products from the user's cart.

- **removeIndividualFromCart(userId, productId):**
  - Removes a specific product from the user's cart.

- **getCartData(userId):**
  - Retrieves the user's cart data.

### 2. FavouriteService

The `FavouriteService` manages the user's wishlist. It provides the following functionalities:

- **addProductInFavourite(userId, productId):**
  - Adds a product to the user's wishlist.

- **clearAllProductFromFavourite(userId):**
  - Removes all products from the user's wishlist.

- **removeIndividualFromFavourite(userId, productId):**
  - Removes a specific product from the user's wishlist.

- **getFavouriteData(userId):**
  - Retrieves the user's wishlist data.
 
## 3. ProductService

The `ProductService` handles operations related to products, offering the following functionalities:

- **addProductInDatabase(productModal):**
  - Adds a product to the database.

- **getOneProductFromDatabase(productId):**
  - Retrieves details of a specific product from the database.

- **getAllProductFromDatabase():**
  - Retrieves details of all products from the database.

- **getProductBySearch(searchText):**
  - Retrieves a list of products from the database based on a search query.
  


## Directory Structure

```plaintext
service:
  - CartService:
    - addProductInCart
    - increaseProductQuantityInCartByOne
    - decreaseProductQuantityInCartByOne
    - setProductQuantityInCartByNumber
    - clearAllProductFromCart
    - removeIndividualFromCart
    - getCartData
  - FavouriteService:
    - addProductInFavourite
    - clearAllProductFromFavourite
    - removeIndividualFromFavourite
    - getFavouriteData
  - ProductService:
    - addProductInDatabase
    - getOneProductFromDatabase
    - getAllProductFromDatabase
    - getProductBySearch
  

```

## Instructions for Running the Services

1: Add the dependency


## Maven

Add the following dependency to your Maven `pom.xml` file:

```xml
<dependency>
		<groupId>com.ecommerce</groupId>
		<artifactId>services</artifactId>
		<version>1.0.0</version>
</dependency>
```

## Gradle

Add the following implementation to your Gradle `build.gradle` file:

```gradle
implementation 'com.ecommerce:services:1.0.0'
```

2: Add the authentication in your project for github-packages

# Maven

## intellij

- Select your project
- Right click on project 
- Select maven -> open setting.xml 
- Copy below and paste into setting.xml

```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/Deependra-009/E-COMMERCE-SPRING-DEPENDENCY</url>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_PERSONAL_ACCESS_TOKEN</password>
    </server>
  </servers>
</settings>
```

## For other IDE. So check on google: `how to open setting.xml file on you IDE`

#Gradle

```gradle
plugins {
    id("maven-publish")
}
publishing {
    repositories {
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/Deependra-009/E-COMMERCE-SPRING-DEPENDENCY")
            credentials {
                username = "YOUR_GITHUB_USERNAME"
                password = "YOUR_PERSONAL_ACCESS_TOKEN"
            }
        }
    }
    publications {
        gpr(MavenPublication) {
            from(components.java)
        }
    }
}
```

**Note:** Ensure that you have the necessary access rights to the GitHub repository and provide the correct credentials for authentication.


```
mvn install
```
or
```
click build module
```

## Don't forget to add this annotation in main class

```java
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ecommerce.*")
```

## How to use

you have to create an object of CartService:
Normal Way
```java
CartService cartService=new CartServiceImplementation
```
Springboot
```java
@Autowired
CartServiceImplementation cartServicImplementation;
```


## Future Enhancements

In the future, additional features will be added, including:

- **Authentication and Authorization:**
  - Secure the services with authentication and authorization mechanisms to protect user data.

- **Caching:**
  - Implement caching mechanisms to optimize and improve the performance of the services.

The `FilterService` manages various filters to enhance the user's shopping experience. It provides the following functionalities:

- **applyCategoryFilter(category):**
  - Filters products based on the specified category.

- **applyPriceRangeFilter(minPrice, maxPrice):**
  - Filters products within the specified price range.

- **applyRatingFilter(minRating):**
  - Filters products with a rating equal to or above the specified minimum.

- **Dynamic Filters:**
  - Implement dynamic filters that adjust based on user preferences and browsing history.
    
- **placeOrder(userId, productIds):**
  - Places an order for the specified products.

- **trackOrder(orderId):**
  - Provides real-time tracking information for a specific order.

- **cancelOrder(orderId):**
  - Allows users to cancel a placed order.
 
- **Order History:**
  - Implement a feature for users to view their order history and reorder previous purchases.

- **Automated Order Tracking:**
  - Integrate automated notifications for real-time order tracking.     
     




