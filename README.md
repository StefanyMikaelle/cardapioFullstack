# Cardápio Fullstack

Esse projeto tem como objetivo fazer um aplicação completa fullstack , usando no backend Spring Boot com Java, no Frontend React e o banco de dados PostgreSQL , para fixar mais o conteúdo de forma prática.


## 🔨 Referências


O [Video referência Frontend] (https://www.youtube.com/watch?v=WHruc3_2z68&list=PLNCSWIsR6ADJpKXDybHpXTOnVmxZFQaAE&index=2)
O [Video referência Backend] (https://www.youtube.com/watch?v=lUVureR5GqI&list=PLNCSWIsR6ADJpKXDybHpXTOnVmxZFQaAE&index=1))

## ✔️ Técnicas e tecnologias utilizadas

Lista de ferramentas utilizadas:

- `React`
- `Spring Boot`
- `Postgree`

E muito mais!

## 🛠️ Rodar o Postgree
Configure o admin e senha desse banco 

Crie manualmente o banco food e a tabela foods com esse comando :

CREATE TABLE foods (
    id SERIAL PRIMARY KEY,
    title VARCHAR(800) NOT NULL,
    image VARCHAR(800),
    price INTEGER
);

depois atribua as permissões .


## 🛠️ Abrir e rodar o projeto BACKEND


Essa aplicação foi desenvolvido utilizando Java Spring e Spring MVC para criação do servidor, Spring Data JPA para manipulação e persistência de dados, 
Lombok para geração de boilerplates e Postgres Driver para realizar a conexão com banco de dados Postgress.

Para rodar esse projeto você precisa ter o Java instalado na sua máquina.

Agora, dentro do IntelliJ, vamos instalar as depedências com o Maven, rodando o 
`Lifecycle : package `



## 🛠️ Abrir e rodar o projeto FRONTEND

Antes de iniciar, você deve ter o Node.js e o NPM instalados em sua máquina.

Primeiro, você deve clonar o projeto na sua máquina, para isso você pode colar o seguinte comando em seu terminal


`git clone`

Para instalar as dependências, execute o seguinte comando:

`npm install`

Por fim, para executar o projeto basta rodar o seguinte:

`npm run dev`



## 📚 Mais informações do projeto

Esse projeto terá muito mais funcionalidades com o decorrer do tempo
