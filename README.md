# Kafka

Utilizar o docker-compose.yml para emular o kafka, zookeeper e o kafka-ui. O Objetivos dessas POCs é produzir e consumir uma mensagem com o kafka, porem sem utilizar diretrizes de segurança

## Executar 
```
docker compose up -d --build
```

## Acessar o  kafka-ui
```
http://localhost:8081/ 
```
![image](https://github.com/rmcarvalhoo/kafka/assets/3673048/061bc2e8-dd57-40ec-aa77-fb5b6e51821b)


## Neste respositorio temos os projetos:
- consumer1
```
  Java 21
  Maven 3.9
  Lombok
  spring-kafka
```
  Enpoint: 
  ```
  curl --location 'http://localhost:8080/product/' \
  --header 'Content-Type: application/json' \
  --data '{
      "name": "tomada",
      "price": 7
  }'
  ```
![image](https://github.com/rmcarvalhoo/kafka/assets/3673048/4024bdd2-0c76-4c31-9082-14301ce44c8b)


- producer1
```
  Java 21
  Maven 3.9
  Lombok
  spring-kafka
```
