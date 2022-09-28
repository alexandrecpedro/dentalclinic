# Dentalclinic

Projeto de Consultas de uma Clínica Odontológica

## 🚀 Começando

Consulte **[Implantação](#-implantao)** para saber como implantar o projeto.
### 🎲 Diagrama UML

![Imagem do diagrama UML](./images/diagrama-dentista.png)

## 📦 Testes API - POSTMAN
> URL: http://localhost:8080
#### Autentication
Para os testes é preciso ter o token de autorirazação.
```json
{
    "email": "admin@dh.com",
    "senha":"admin"
}
```
```
GET /usuario/authenticate
```
#### TIPO USUÁRIO
> POST /tipoUsuario/salvar
```json
{
    "logradouro":"uuuuuuuuuuu",
    "numero":"12",
    "complemento":"qweer",
    "bairro":"santarem",
    "localidade":"sao paulo",
    "uf":"PA",
    "cep":"123456"
}
```
#### ENDEREÇO
> POST /endereco/salvar
```json
{
    "logradouro":"uuuuuuuuuuu",
    "numero":"12",
    "complemento":"qweer",
    "bairro":"santarem",
    "localidade":"sao paulo",
    "uf":"PA",
    "cep":"123456"
}
```
#### USUÁRIO
> POST /usuario/salvar
```json
{
  "email": "pedro@gmail.com",
  "senha": "123456778",
  "enderecoDTO": {
    "nome": "Paciente"
  }
}
```
#### PACIENTE
> POST /paciente/salvar
```json
{
    "nome": "Marcos",
    "sobrenome": "Pedro",
    "cpf": "1231231235",
    "telefone": "99999-9999",
    "usuarioDTO": {
        "email": "marcos@gmail.com",
        "senha": "123321123",
        "tipoUsuarioDTO": {
            "nome": "Paciente"
        }
    },
    "enderecoDTO": {
        "logradouro": "uuuuuuuuuuu",
        "numero": "12",
        "complemento": "qweer",
        "bairro": "santarem",
        "localidade": "sao paulo",
        "uf": "PA",
        "cep": "123456"
    }
}
```
#### DENTISTA
> POST /dentista/salvar
```json
{
    "nome": "Fabio",
    "sobrenome": "Neres",
    "cro": "123456",
    "usuarioDTO": {
        "email": "fabio@gmail.com",
        "senha": "12345678",
        "tipoUsuarioDTO": {
            "nome": "ADMIN"
        }
    },
    "clinicaDTO": {
        "nomeFantasia": "Clinica X",
        "razaoSocial": "Clinica X",
        "enderecoDTO": {
            "logradouro": "Rua Manuel Teles Vitancos",
            "numero": "598",
            "complemento": "CASA 018",
            "bairro": "Belém‎",
            "localidade": "São Paulo",
            "uf": "SP",
            "cep": "00000-016"
        }
    }
}
```
#### CLINICA
> POST /clinica/salvar
```json
{
  "nomeFantasia":"Clinica Feliz", 
  "razaoSocial":"Clinica Feliz", 
  "enderecoDTO":{
    "logradouro":"Rua Germano Vítor dos Santos",
    "numero":"598",
    "complemento":"CASA 013",
    "bairro":"Morumbi",
    "localidade":"LOCALIDADE 1",
    "uf":"SP",
    "cep":"00000-001"}
}
```
#### CONSULTA
> POST /consulta/salvar
```json
{
    "descricao": "",
    "status": "",
    "pacienteDTO": {
        "nome": "Marcos",
        "sobrenome": "Pedro",
        "cpf": "1231231235",
        "telefone": "99999-9999",
        "usuarioDTO": {
            "email": "marcos@gmail.com",
            "senha": "123321123",
            "tipoUsuarioDTO": {
                "nome": "Paciente"
            }
        },
        "enderecoDTO": {
            "logradouro": "uuuuuuuuuuu",
            "numero": "12",
            "complemento": "qweer",
            "bairro": "santarem",
            "localidade": "sao paulo",
            "uf": "PA",
            "cep": "123456"
        }
    },
    "dentistaDTO": {
        "nome": "Fabio",
        "sobrenome": "Neres",
        "cro": "123456",
        "usuarioDTO": {
            "email": "fabio@gmail.com",
            "senha": "12345678",
            "tipoUsuarioDTO": {
                "nome": "ADMIN"
            }
        },
        "clinicaDTO": {
            "nomeFantasia": "Clinica X",
            "razaoSocial": "Clinica X",
            "enderecoDTO": {
                "logradouro": "Rua Manuel Teles Vitancos",
                "numero": "598",
                "complemento": "CASA 018",
                "bairro": "Belém‎",
                "localidade": "São Paulo",
                "uf": "SP",
                "cep": "00000-016"
            }
        }
    },
    "data": "27/09/2022",
    "hora": "21:22"
}
```
## 📦 Implantação

### [Postman](Postman/TURMA1.postman_collection.json)
![Imagem postman](./images/postman.png)
## 🛠️ Construído com

* [Spring Boot](https://spring.io/) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Postman](https://www.postman.com/) - Usada para teste de APIs
* [Intellij](https://www.jetbrains.com/idea/) - Usada para desenvolvimento
* [MySQL - Workbench](https://www.mysql.com/products/workbench/) - Usada para gerar banco de dados

## 🔗 Dependências
_Versão Java_
```java
<java.version>17</java.version>
```
```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
<version>2.7.3</version>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<scope>runtime</scope>
<optional>true</optional>
</dependency>
<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>
</dependency>
<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-entitymanager</artifactId>
<version>5.6.11.Final</version>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<optional>true</optional>
</dependency>
<dependency>
<groupId>io.jsonwebtoken</groupId>
<artifactId>jjwt</artifactId>
<version>0.9.1</version>
</dependency>
<dependency>
<groupId>javax.xml.bind</groupId>
<artifactId>jaxb-api</artifactId>
<version>2.4.0-b180830.0359</version>
</dependency>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.springframework.security</groupId>
<artifactId>spring-security-test</artifactId>
<scope>test</scope>
</dependency>
```

## ✒️ Autores

* **Alexandre C. Pedro** - *Trabalho Inicial/Desenvolvimento/Teste/Implementação* - [Desenvolvedor](https://github.com/alexandrecpedro)
* **Fábio Neres** - *Trabalho Inicial/Desenvolvimento/Teste/Implementação* - [Desenvolvedor](https://github.com/neresfabio)
* **Tiago Vale** - *Trabalho Inicial/Desenvolvimento* - [Desenvolvedor](https://github.com/tpvale)
* **SanKler** - *Trabalho Inicial/Desenvolvimento* - [Desenvolvedor](https://github.com/linkParaPerfil)
* **Atef Chelaghma** - *Trabalho Inicial/Desenvolvimento* - [Desenvolvedor](https://github.com/linkParaPerfil)
* **Bruno Furukawa** - *Trabalho Inicial/Desenvolvimento/Teste/Implementação* - [Desenvolvedor](https://github.com/bfurukawa)

---
