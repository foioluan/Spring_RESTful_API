[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[BOOTSTRAP_BADGE]: https://img.shields.io/badge/bootstrap-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[THYMELEAF_BADGE]: https://img.shields.io/badge/thymeleaf-%236DB33F.svg?style=for-the-badge&logo=thymeleaf&logoColor=white

<h1 align="center" style="font-weight: bold;">Spring REST API 💻</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]

<p align="left">
  <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> 
</p>

<p align="justify">
  <b>Projeto desenvolvido como parte da disciplina de Programação Web do curso de Análise e Desenvolvimento de Sistemas da UFRN. O objetivo principal é demonstrar o uso do Spring Boot para desenvolvimento de uma API RESTful, utilizando Docker para a construção do contêiner do banco de dados</b>
</p>

<h2 id="started">🚀 Instruções de Uso</h2>

1. Crie um Banco de Dados no seu administrador de desenvolvimento para o PostgreSQL ou diretamente no contêiner Docker, criando assim o Banco de Dados inicial para testes. Com isso feito, siga os passos abaixo.
2. Clone o repositório e acesse a pasta do projeto:
  
       $ git clone https://github.com/foioluan/spring_rest_api.git
       $ cd *nome_da_sua_pasta*

3. Crie um arquivo application.propertier na raiz do projeto e insira suas credencias. Utilize como exemplo:
  ```yaml
  spring.datasource.url=jdbc:postgresql://{DATABASE_HOST}:{DATABASE_PORT}/{DATABASE_NAME}
  spring.datasource.username={DATABASE_USERNAME}
  spring.datasource.password={DATABASE_PASSWORD}
  spring.datasource.driver-class-name=org.postgresql.Driver

  spring.jpa.show-sql=true
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.generate-ddl=true
  
  spring.jpa.properties.hibernate.show_sql=true
  spring.jpa.properties.hibernate.use_sql_comments=true
  ```
5. Execute o projeto;
6. Utilize um software como Insomnia ou Postman para testar a API.

<h2 id="routes">📍 API Endpoints</h2>
​

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /usuarios/</kbd>     | Lista todos os usuários cadastrados
| <kbd>GET /usuarios/{id}</kbd>     | Lista o usuário com {id} especifíco
| <kbd>POST /usuarios/</kbd>     | Adiciona um novo usuário
| <kbd>DELETE /usuarios/{id}</kbd>     | Deleta um usuário com {id} específico (soft delete)
| <kbd>PUT /usuarios/{id}</kbd>     | Atualiza as informações de um usuário com {id} específico
| <kbd>GET /perfil/</kbd>     | Lista todos os perfis de usuários cadastrados
| <kbd>GET /perfil/{id}</kbd>     | Lista o perfil do usuário com {id} especifíco
| <kbd>POST /perfil/</kbd>     | Adiciona um perfil a um usuário
| <kbd>DELETE /perfil/{id}</kbd>     | Deleta o perfil de um usuário com {id} específico (soft delete)
| <kbd>PUT /perfil/{id}</kbd>     | Atualiza as informações do perfil de um usuário com {id} específico
| <kbd>GET /enderecos/</kbd>     | Lista todos os endereços de usuários cadastrados
| <kbd>GET /enderecos/{id}</kbd>     | Lista o endereço com {id} especifíco
| <kbd>POST /enderecos/</kbd>     | Adiciona um endereco a um usuário
| <kbd>DELETE /enderecos/{id}</kbd>     | Deleta um endereco com {id} específico (soft delete)
| <kbd>PUT /enderecos/{id}</kbd>     | Atualiza as informações de um endereco com {id} específico
| <kbd>GET /produtos/</kbd>     | Lista todos os produtos cadastrados
| <kbd>GET /produtos/{id}</kbd>     | Lista o produto com {id} especifíco
| <kbd>POST /produtos/</kbd>     | Adiciona um novo produto
| <kbd>DELETE /produtos/{id}</kbd>     | Delete um produto com {id} específico (soft delete)
| <kbd>PUT /prosutos/{id}</kbd>     | Atualiza as informações de um produto com {id} específico
| <kbd>GET /categorias/</kbd>     | Lista todas as categorias cadastradas
| <kbd>GET /categorias/{id}</kbd>     | Lista a categoria com {id} especifíco
| <kbd>POST /categorias/</kbd>     | Adiciona uma nova categoria
| <kbd>DELETE /categorias/{id}</kbd>     | Delete uma categoria com {id} específico (soft delete)
| <kbd>PUT /categorias/{id}</kbd>     | Atualiza as informações de uma categoria com {id} específico
