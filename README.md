# CRUD de Contatos - Android App

Este projeto é uma aplicação Android desenvolvida em Java que implementa um CRUD (Create, Read, Update, Delete) para gerenciar contatos, utilizando o banco de dados nativo do Android, o SQLite. O aplicativo permite o cadastro, visualização, alteração e exclusão de contatos, com campos como Nome, E-mail, Telefone, RA, CPF, Curso, Ano e Turno.

## Funcionalidades

- Adicionar Contatos: Insere novos registros de contatos no banco de dados.
- Listar Contatos: Exibe todos os contatos cadastrados em um ListView utilizando um ArrayAdapter.
- Atualizar Contatos: Permite a edição de informações de um contato existente.
- Deletar Contatos: Remove contatos do banco de dados.


## Estrutura do Projeto

### 1. DatabaseHelper

- Classe responsável por criar e gerenciar o banco de dados.
- Funções de CRUD implementadas:
  - addContato: Insere novos contatos.
  - getAllContatos: Retorna todos os contatos do banco.
- Estrutura do banco inclui os campos: id, nome, email, telefone, ra, cpf, curso, ano, turno.

### 2. MainActivity

- Tela principal onde o usuário pode adicionar novos contatos.
- Contém formulários para cada campo: Nome, E-mail, Telefone, RA, CPF, Curso, Ano, e Turno.

- Botões:
  - Salvar: Salva o novo contato no banco de dados.
  - Ver Contatos: Navega para a tela de listagem de contatos.


### 3. ListarContactsActivity

- Tela que exibe todos os contatos cadastrados utilizando um ListView.
- Utiliza um ArrayAdapter para exibir cada contato no formato: "Nome - E-mail - Telefone - RA - CPF - Curso - Ano - Turno".
 - Carrega os dados do banco de dados por meio do método getAllContatos().


## Adapters

- ArrayAdapter: É utilizado para converter o array de strings (contatos) em itens de interface exibidos no ListView.
- O ArrayAdapter facilita a exibição dos contatos de forma estruturada e organizada, tornando a UI dinâmica.


## Layouts

- activity_main.xml
  - Contém EditText para inserção dos dados dos contatos e botões para salvar ou visualizar contatos.

- activity_listar_contacts.xml
  - Simples layout com um ListView para exibição dos contatos.

## Como Executar o Projeto

- Clone o repositório em seu ambiente local.
- Abra o projeto no Android Studio.
- Compile e execute o projeto em um dispositivo ou emulador Android.
- Utilize a tela principal para cadastrar novos contatos e, em seguida, visualize-os na tela de listagem.


## Requisitos
- Android Studio (versão 4.0 ou superior)
- Dispositivo Android com API mínima 16 (Jelly Bean)


## Tecnologias Utilizadas
- Java
- Android SDK
- SQLite


## Melhorias Futuras
- Implementação de pesquisa por nome, RA ou CPF.
- Adição de funcionalidades para ordenar a listagem de contatos.
- Integração com API externa para sincronizar os contatos.
