# Projeto de conclusão da disciplina de Persistence da FIAP (MBA)

Esse projeto tem o objetivo de demonstrar a utilização de diferentes tipos de bancos de dados (SQL e NoSQL), nos contextos de persistência e caching.

# Dependências

- Java 11
- Maven
- Docker

# Como executar (Unix/MacOS)

Abra um terminal na raiz do projeto e digite os comandos:

- buildar as aplicações
> ./service--produto/mvnw clean package && \ \
> ./service--pedido/mvnw clean package && \ \
> ./service--cliente/mvnw clean package && \ \
> ./api--ecommerce/mvnw clean package
- executar o ambiente com docker-compose
> docker-compose -f docker-compose.yml up -d
- encerrar o ambiente
> docker-compose down

# Postman

Na pasta "postman_collections" na raiz do projeto, estão as collections e o environment do Postman para importação

# URL dos Serviços

### API e-commerce

Serviço que gerencia e orquestra o e-commerce
- localhost:5000

### Service cliente

Micro-serviço do domínio de clientes
- localhost:5001

### Service pedido

Micro-serviço do domínio de pedidos
- localhost:5002

### Service produto

Micro-serviço do domínio de produtos
- localhost:5003

### Mongo-Express

Permite visualizar os dados salvos no MongoDB
- localhost:8081

### Jaeger

Tracing distribuído para analisar os micro-serviços
- localhost:9090

### Prometheus

Coleta e agrega as métricas dos micro-serviços
- localhost:9091

### Grafana

Coleta as métricas do Prometheus e exibe em dashboards
- localhost:9092
- username: root
- password: root

# Arquitetura

Foi utilizada uma arquitetura de micro-serviços, visando utilizar diferentes paradigmas de bancos de dados para fins didáticos.

![arquitetura](./assets/persistence-arquitetura.drawio.png)

# Diagrama das Bases de Dados

- ### service-cliente
![db-service-cliente](./assets/db-service--cliente.png)

- ### service--produto
![db-service-cliente](./assets/db-service--produto.png)

- ### service--pedido
![db-service-cliente](./assets/db-service--pedido.png)