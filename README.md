# Wallet API

API REST para gerenciamento de usuários e carteiras digitais.  
O projeto foi construído utilizando Java, Spring Boot, JPA e PostgreSQL, seguindo boas práticas de arquitetura em camadas.

---

## 🚀 Tecnologias

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- Bean Validation  
- PostgreSQL  
- Lombok  
- Maven  

---

## 📁 Arquitetura

O sistema segue a separação por responsabilidades:

```
controller  -> entrada das requisições HTTP  
service     -> regras de negócio  
repository  -> acesso ao banco de dados  
entity      -> representação das tabelas  
```

---

## ⚙️ Configuração do ambiente

### Pré-requisitos

- Java 21+
- Maven
- PostgreSQL rodando

---

### Banco de dados

Criar um banco com o nome:

```
wallet
```

---

### application.properties (exemplo)

```
spring.datasource.url=jdbc:postgresql://localhost:5432/wallet
spring.datasource.username=postgres
spring.datasource.password=123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Como executar o projeto

1. Clonar o repositório

```
git clone <url-do-repo>
```

2. Entrar na pasta do projeto

```
cd wallet
```

3. Rodar a aplicação pela classe principal.

A API iniciará em:

```
http://localhost:8080
```

---

## 📌 Endpoints

### Usuários
```
GET    /users
POST   /users
```

### Carteiras
```
GET    /wallets
POST   /wallets
```

*(Os endpoints podem variar conforme a implementação dos controllers.)*

---

## 🧠 Funcionalidades atuais

✔ Cadastro de usuários  
✔ Criação de carteiras  
✔ Integração com banco PostgreSQL  
✔ Persistência com JPA  
✔ Estrutura preparada para autenticação  
✔ Base pronta para evoluir para transferências e operações financeiras  

---

## 🔮 Próximas evoluções

- Autenticação e autorização
- Transferência entre carteiras
- Controle de saldo
- Logs de transações
- Documentação com Swagger
- Deploy em nuvem

---

## 👨‍💻 Autor

João Guedes

---

## 📄 Licença

Projeto para fins de estudo e evolução profissional.
