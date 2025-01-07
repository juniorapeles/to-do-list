# To-Do List Java Project

Um projeto backend desenvolvido em Java com Spring Boot para gerenciar tarefas. A API suporta operações CRUD para tarefas e funcionalidades avançadas, como autenticação de usuários e organização por categorias e prioridades.

## Status do Projeto

- ✅ CRUD completo para tarefas (Criar, Ler, Atualizar, Deletar).

## Próximas Etapas

### 1. Autenticação de Usuários

- [x] Implementar autenticação com JWT.
    - [x] Criar endpoints para login e registro de usuários.
    - [x] Proteger as rotas com Spring Security.
- [x] Adicionar roles para usuários (e.g., `admin`, `user`).

### 2. Funcionalidades Básicas de Tarefas

- [ ] Adicionar campos para:
    - [ ] Prioridade da tarefa (e.g., `Alta`, `Média`, `Baixa`).
    - [ ] Status da tarefa (e.g., `Pendente`, `Concluído`).
    - [ ] Data de vencimento.
- [ ] Implementar filtros de pesquisa:
    - [ ] Filtrar por prioridade.
    - [ ] Filtrar por status.
    - [ ] Filtrar por data de vencimento.

### 3. Funcionalidades Avançadas

- [ ] Categorias de Tarefas:
    - [ ] Permitir que o usuário organize tarefas por categorias.
    - [ ] Criar endpoints para adicionar, editar e remover categorias.
- [ ] Notificações:
    - [ ] Enviar lembretes por e-mail para tarefas próximas da data de vencimento.
    - [ ] Adicionar suporte a notificações em tempo real (opcional).
- [ ] Compartilhamento de Tarefas:
    - [ ] Permitir que usuários compartilhem tarefas com outros usuários.

### 4. Testes e Documentação

- [ ] Escrever testes unitários para os serviços e controladores.
- [ ] Criar testes de integração para os endpoints.
- [ ] Adicionar documentação Swagger/OpenAPI.
- [ ] Configurar um ambiente para testes local.

### 5. Deploy e Dockerização

- [ ] Criar um arquivo `Dockerfile` para containerizar o projeto.
- [ ] Configurar um `docker-compose.yml` para banco de dados e aplicação.
- [ ] Fazer deploy em um ambiente na nuvem (e.g., AWS, Heroku, ou DigitalOcean).

### 6. Melhorias Contínuas

- [ ] Implementar paginação nos endpoints de listagem de tarefas.
- [ ] Adicionar cache para melhorar a performance.
- [ ] Monitorar e fazer logging com ferramentas como ELK Stack ou Prometheus + Grafana.

## Estrutura de Arquivos (Atual e Planejada)

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com.example.todo/
│   │   │   ├── controller/   # Controladores da API
│   │   │   ├── model/        # Modelos de dados (Entidades)
│   │   │   ├── repository/   # Repositórios (JPA)
│   │   │   ├── service/      # Lógica de negócios
│   │   │   ├── security/     # Configuração de segurança e JWT (planejado)
│   ├── resources/
│   │   ├── application.yml   # Configuração da aplicação
├── test/                     # Testes unitários e de integração
Dockerfile                    # Arquivo Docker (planejado)
docker-compose.yml            # Configuração de container (planejado)
README.md                     # Documentação do projeto
```

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security (planejado)
- JPA/Hibernate
- Banco de Dados: MySQL ou PostgreSQL
- Swagger/OpenAPI (planejado)
- Docker (planejado)

## Contribuições

Contribuições são bem-vindas! Por favor, crie uma *issue* ou envie um *pull request* com suas melhorias.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
