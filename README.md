# Coding Challenge forTechnical Consultants

## Authors
- [L Simonnet](mailto:larent.simonnet@gmail.com)

SimpleRestclient is a simple application for Camunda test
Application that can be used as a client for the given REST endpoint. 
In  detail, you will have :
1. A Java Class User that contains the fields id, email, firstName and
   lastName.
2. A Java Class UserClient that contains a method for querying the first page
   of the given REST endpoint. Result is returned as List<User>.
3. A main method is available in  UserClient that calls the above method and also prints the
   firstName and lastName of each user to the console.
4. A unit test for UserClient that tests
   a. if the method from 2. returns the expected amount of users
   b. if the first name of the first user in the list is “George”

## Installation

Not applicable

## Usage

```java
        java person.lst.camunda.test.UserClient
```

