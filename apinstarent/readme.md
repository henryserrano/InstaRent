# Api for InstaRent


## Running the Application


http://localhost:8080/home

You can see a table to navigate in the data


####  GET Get with pagination



http://localhost:8080/customer/0/10

#### POST Service post


http://localhost:8080/customer/create

```
{"name":"Diego Sanchez",
"city":"Cali"}
```



####PUT Update
http://localhost:8080/customer/0/1

```
{"name":"Diego Sanchez",
"city":"Cali"}
```


####DEL Service delete
http://localhost:8080/customer/1



## H2 Console

- http://localhost:8000/h2-console
- Use `jdbc:h2:mem:henryserrano` as JDBC URL 

