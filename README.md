# 🌐 App Ensino Matemática – Gateway · Socratic
Este repositório contém o Gateway do Socratic, aplicativo educacional de matemática voltado para a comunidade externa.

O Gateway atua como ponto de entrada único (API Gateway) para todos os microsserviços, cuidando de roteamento, segurança e observabilidade — garantindo uma experiência unificada e segura para alunos, professores e demais consumidores da API.

# ⚙️ Funções do Gateway no projeto
- Roteamento inteligente para os microsserviços de Usuários, Questões e Respostas;

- Validação centralizada de JWT, emitido pelo microsserviço de Usuários;

- Integração com Eureka Server para descoberta de serviços e balanceamento de carga;

- Políticas de CORS configurada em um único ponto;

# 🧭 Sumário
- [Contribuidores](#contribudores)
- [Microsserviços atendidos](#microsserviços-atendidos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Execução do Projeto](#execução-do-projeto)
- [Licença](#licença)

# Contribuidores
- [@fromanoel](https://github.com/fromanoel) – Backend: desenvolvimento e integração dos microsserviços, configuração do Gateway e do Eureka Server, e organização da documentação com Swagger.
- [@madu-silva](https://github.com/madu-silva) – Backend: integração com Firebase, geração do token JWT.
- [IsabelaQM](https://github.com/IsabelaQM) – Frontend: desenvolvimento da aplicação em React e React Native.
- [@samylledutra](https://github.com/samylledutra) – Frontend: desenvolvimento da aplicação em React e React Native.
- [@stclaire1](https://github.com/stclaire1) – Frontend: desenvolvimento da aplicação em React e React Native.

# 🔗 Microsserviços atendidos

👉 [Backend - Usuários](https://github.com/projetos-si-iftm/app-matematica-backend)
Gerenciamento de alunos, professores e turmas, além da autenticação com Firebase e geração de JWT.

👉 [Backend - Questões](https://github.com/projetos-si-iftm/app-matematica-backend-questao)
Gerenciamento do banco de questões de matemática.

👉 [Backend - Respostas](https://github.com/projetos-si-iftm/app-matematica-backend-resposta)
Gerenciamento das rodadas de respostas realizadas pelos alunos e do ranking.

# 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Spring Security (JWT)
- Maven

# 🖥️ Configuração do Ambiente

## Clone o repositório
```bash
git clone https://github.com/projetos-si-iftm/app-matematica-backend-gateway.git
cd app-matematica-backend-gateway
```
### Variáveis importantes
- `EUREKA_URL` – URL do Eureka (http://localhost:8761)

`CHAVE_ASSINATURA_JWT` – chave usada para validar os tokens emitidos pelo microsserviço de Usuários

Você pode definir essas variáveis em application.yml ou via variáveis de ambiente.

## 🚀 Execução do Projeto
```bash
mvn clean install
mvn spring-boot:run
```
### Exemplo de rota:
GET /api/usuarios/estudantes → encaminha para o microsserviço de Usuários, desde que o token JWT seja válido.

## 📜 Licença
Este projeto está licenciado sob a Licença Apache 2.0.
Consulte o arquivo LICENSE para mais detalhes.
