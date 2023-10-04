## Projeto JDBC 

# Objetivo
Criar um projeto para aceso ao banco de dados com a api padrão JDBC, onde será disponibilzado as quatros operacoes basicas de persistencia(insert, delete, update e read)

# Padrão do projeto
- Factory -> Para criar os objetos da classe que implementa a interface
- Dao -> Para separar a logica de acesso a dados -> InterfaceDao e Entidades

![image](https://github.com/victorvaz001/projectJDBC/assets/42657636/21c168b1-83b1-4819-a95d-bb9668774245)

# Entidades

![image](https://github.com/victorvaz001/projectJDBC/assets/42657636/d1e28f59-cfe8-4e91-9cd9-ff0d8e3b92da)


# Funcionalidades
- insert
- delete
- update
- findById
- findBySector
- findAll

# Como executar o projeto
- Clonar o repositorio **git clone**
- Baixar o **conector.jar** do mysql(https://dev.mysql.com/downloads/connector/j/) ou outro banco
- Criar o projeto java
- Na raiz do proejto, criar um arquivo db.properties, colocar dados de conexão abaixo
  user=informar-usuário-do-banco
  password=sua-senha
  dburl=jdbc:mysql://localhost:3306/informar-nome-do-banco
  useSSL=false
- Adicionar o jar ao projeto
- Criar um banco chamado company
- Criar as tabelas Employee e Sector conforme diagrama de entidades

# Autor
- Victor Vaz
  
  https://www.linkedin.com/in/victor-goncalves-vaz-/
