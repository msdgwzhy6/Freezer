# Freezer

[![Build Status](https://travis-ci.org/florent37/Freezer.svg?branch=master)](https://travis-ci.org/florent37/Freezer)

Use Annotations to mark classes to be Persisted

```java
@Model
public class User {
    int age;
    String name;
    Cat cat;
    List<Dog> dogs;
}
```

```java
@Model
public class Dog {
    String name;
}
```

```java
@Model
public class Cat {
    String shortName;
}
```

#Persist datas

Persist your data easily

```java
UserORM userEntityManager = new UserEntityManager();

User user = ... // Create a new object
userEntityManager.add(user);
```

#Querying

##Simple
```java  
List<User> allUsers = userEntityManager.select()
                             .asList();
                             
User user3 = userEntityManager.select()
                    .age().equalsTo(3)
                    .first();
```

##Complex

Freezer query engine uses a Fluent interface to construct multi-clause queries

```java  
List<User> allUsers = userEntityManager.select()
                                .name().equalsTo("florent")
                             .or()
                                .cat(CatEntityManager.where().shortName().equalsTo("Java"))
                             .or()
                                .dogs(DogEntityManager.where().name().equalsTo("Sasha"))
                             .asList();
```

##Selectors

```java
//strings
     .name().equalsTo("florent")
     .name().notEqualsTo("kevin")
     .name().contains("flo")
//numbers
     .age().equalsTo(10)
     .age().notEqualsTo(30)
     .age().greatherThan(5)
     .age().between(10,20)
//booleans
     .hacker().equalsTo(true)
     .hacker().isTrue()
     .hacker().isFalse()
```

##Aggregation

```java
float agesSum      = userEntityManager.select().sum(UserColumns.age);
float agesAverage  = userEntityManager.select().average(UserColumns.age);
float ageMin       = userEntityManager.select().min(UserColumns.age);
float ageMax       = userEntityManager.select().max(UserColumns.age);
int count          = userEntityManager.select().count();
```

#Accepted types

##Primitives

```java
- int
- float
- boolean
- String
```

##Collections

```java
- List<Integer>
- List<Float>
- List<Boolean>
- List<String>
```

##Arrays

```java
- int[]
- float[]
- boolean[]
- String[]
```

##One To One

```java
@Model
public class User {
    Cat cat;
}

```

##One To Many

```java
@Model
public class User {
    List<Dog> dogs;
}

```

#Logging

```java
userEntityManager.logQueries((query, datas) -> Log.d(TAG, query) }
```

#TODO

- Update an entry
- Adding SqlLiterHelper onUpgrade
- Adding some selectors operations (like, ...)
- Adding Observable support

#A project initiated by Xebia

This project was first developed by Xebia and has been open-sourced since. We will continue working and investing on it.
We encourage the community to contribute to the project by opening tickets and/or pull requests.

[![logo xebia](https://raw.githubusercontent.com/florent37/Android-ORM/master/logo_xebia.jpg)](http://www.xebia.fr/)

License
--------

    Copyright 2015 Xebia, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

