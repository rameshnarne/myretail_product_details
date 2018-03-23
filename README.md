# MyRetail Product Details App
-----------------------------------
Objective of this app is to create a RESTful service that can retrieve product and price details by supplied Id.

This app implemented with the help of SpringBoot and Java capabilities. Product Data will persist in Redis (NoSQL) server.

In order to Run this App, Please install Redis Server. Please refer below instructions for Windows:

Link to Download Redis:
---------------------------
https://github.com/ServiceStack/redis-windows/raw/master/downloads/redis-latest.zip

Steps to Install:
-------------------
1. Download the redis-latest.zip native 64bit Windows port of redis
2. Extract redis64-latest.zip in any folder, e.g. in c:\redis
3. Run the redis-server.exe using the local configuration
    cd c:\redis
    redis-server.exe redis.windows.conf
4. Run redis-cli.exe to connect to your redis instance
    cd c:\redis
    redis-cli.exe
5. Start playing with redis :)
    redis 127.0.0.1:6379> SET foo bar
    OK
    redis 127.0.0.1:6379> KEYS *
    1) "foo"
    redis 127.0.0.1:6379> GET foo
    "bar"
    redis 127.0.0.1:6379>

Once we Install the Redis, Please clone this APP from below GIT URL:
---------------------------------------------------------------------
https://github.com/rameshnarne/myretail_product_details.git

Install the app in IDE as a Maven Project and Run the MyRetailProductDetailsApplication.java file.


In Order to Validate from Rest Client, Please use below URI:
----------------------------------------------------------------
Update Product Details (PUT) - http://localhost:8090/product-details/products/13860428
Sample JSON Request -

{
    "value": "123.43",
    "currency_code": "USD"
 }

 Retrieve Product Details (GET) - http://localhost:8090/product-details/products/13860428

 Sample Product Details JSON:

 {
     "id": "13860428",
     "name": "The Big Lebowski (Blu-ray) (Widescreen)",
     "current_price": {
         "value": 13.49,
         "currency_code": "USD"
     }
 }


 Thank You.
