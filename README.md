# Insurer App

Uma aplicação simples de gerenciamento de seguros construída com Java, Spring Boot e H2 Database.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.0.6
- H2 Database
- Swagger (OpenAPI)
- Spring Security

## Descrição

O Insurer App é uma aplicação web para gerenciar apólices de seguro. Ela oferece operações CRUD (Create, Read, Update, Delete) 
para apólices de seguro, carros, clientes e motoristas. A aplicação utiliza uma API RESTful para comunicação e utiliza o Spring 
Security para autenticação e autorização.

## Funcionalidades

- Criar, Ler, Atualizar e Excluir apólices de seguro
- Gerenciar informações de carros, como fabricante, modelo e ano
- Armazenar detalhes dos clientes, como nome, e-mail e informações de contato
- Gerenciar informações dos motoristas, como nome, data de nascimento e histórico de sinistros
- Proteger endpoints da API com autenticação e autorização utilizando o Spring Security na classe InsurerSecurityConfig.java
- Gerar documentação da API com Swagger (OpenAPI) em http://localhost:8080/insurer-docs

## Primeiros Passos

Para começar com o Insurer App, siga os seguintes passos:

1. Clone o repositório: `git clone https://github.com/Gordoels/insurer-app`
2. Instale o Java 17, caso ainda não tenha instalado.
3. Instale o Gradle, caso ainda não tenha instalado.
4. Construa o projeto: `gradle build`
5. Acesse a aplicação em http://localhost:8080/insurer-docs

## Documentação da API

A documentação da API é gerada utilizando o Swagger (OpenAPI). Uma vez que a aplicação está em execução, você pode acessar a documentação da API em 
http://localhost:8080/insurer-docs. Essa documentação fornece detalhes sobre os endpoints disponíveis, formatos de requisição/resposta e 
requisitos de autenticação.

## Configuração

A aplicação pode ser configurada utilizando o arquivo `application.properties`. Algumas configurações comuns incluem as configurações do banco de dados, porta do servidor e configurações de segurança. 
Você pode encontrar o arquivo de configuração no diretório `src/main/resources`.

Também há um arquivo de configuração para keys chamado messages.properties onde são armazenados as exceções customizadas.

## Testes

A aplicação inclui testes unitários e testes de integração. Foram cobertos todos os serviços e persistência das regras de negócio.
Você pode rodar os testes com o comando 'gradle test'


## Considerações finais

O banco de dados pode ser acessado no localhost:8080/h2-console.
Este projeto é um desafio também de aprendizado, está totalmente público no link https://github.com/Gordoels/insurer-app, qualquer 
sugestão de melhoria é bem-vinda!

