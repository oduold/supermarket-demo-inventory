# supermarket-demo-inventory

## Introduction

This is a minimal feature implementation of an sample inventory system.

A store receives items into
the store, releases items to the supermarket floor for selling and returns spoilt items to vendors.

### Configuration

* server port set to 8080
* [base url](http://localhost:8080) redirect to [swagger-ui view](http://localhost:8080/swagger-ui)
    * Provides documentation of the API endpoints as well as sample payloads.
* H2 database is used for database persistence
* data.sql is processed on starting the spring boot up to initialise test data
* logging of the application sql queries is enabled

## Features

1. The application allows users to perform CRUD operations on store items i.e.,
   Create items, Read items (list all items and fetch a single item), Update items and Delete
   items.
2. _**TODO**_ - Receive item(s) into the store 
3. _**TODO**_ - Release item(s) into supermarket store
4. _**TODO**_ - Return spoilt items to vendors
5. List items created today
6. List items received from vendors in the store in the last week - [Sample URL](http://localhost:8080/transactions/items?type=receipts&vendor=true&from=2022-11-21&to=2022-11-29) to implement
   * API endpoint [stockTransactionsItems](http://localhost:8080/swagger-ui/index.html#/StockItems/stockTransactionsItems)
7. List spoilt items returned to vendors in the last month - [Sample URL](http://localhost:8080/transactions/items?type=returns&vendor=true&from=2022-10-29&to=2022-11-29) to implement
8. List items released to the supermarket floor today - [Sample URL](http://localhost:8080/transactions/items?type=releases&to=2022-11-29) to implement date range


## Installation and Use

The following installation is on a linux distribution.
Clone this repository or download the ZiP. You can flow the [Help Guides](HELP.md) to get help on how to clone.

### Gradle

Change directory to supermarket-demo-inventory

```$ cd supermarket-demo-inventory```

At root directory. type the following command

```$ gradle```

It will build the project. Use [Help Guides](HELP.md) to get documentation on gradle. 

To run the spring boot application 

```$ gradle bootRun```


