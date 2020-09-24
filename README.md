# articleApplication
Spring Boot Web application to provide REST API in JSON

## 1. Getting started

### 1.1. Récupérer les sources

```
$ git clone https://github.com/ameniJalali/articleApplication.git
```

### 1.2. Lancer l'application

```
$ mvn spring-boot:run
```

### 1.3. API

Method | Path           | Description                    |
-------|----------------|--------------------------------|
GET    | /articles      | retrieve all the articles      |
GET    | /article/{id} | retrieve one article by its ID |

### 2.3. Initialiser un projet Web avec Spring Boot

Créez le fichier ```./pom.xml``` (pour Maven) :
Créez la classe ```./src/main/java/com/github/article/ArticleApplication.java``` :

L'annotation ```@SpringBootApplication``` signifie qu'il s'agit d'une application Spring Boot.

L'instruction ```SpringApplication.run(Application.class, args);``` permet de lancer l'application via un serveur
embarqué (par défaut, Tomcat 7), directemnt depuis le main (clic-droit -> lancer l'application depuis la méthode main).


Lancez l'application :

- soit avec la ligne de commande : ```$ mvn spring-boot:run```
- soit directement 
### 2.5 Déclaration du Modèle de Domaine

Notre modèle du domaine sera simple, à savoir, un simple objet Article (en vrai une Entité JPA), avec pour propriétés :

- l'identifiant de l'entité
- le titre de l'article
- la categorie de l'article

### 2.6. Prise en compte de la persistence avec Hibernate / JPA / Spring Data JPA

Hibernate est l'ORM de référence du monde Java.

JPA est la norme Java standard couvrant la problématique de la persistence de données.

Spring Data JPA est une abstraction de JPA dans l'univers Spring. 
Par défaut, Spring Data JPA utilise Hibernate comme
implémentation 

#### 2.6.1. Déclaration de la dépendance Spring Data JPA pour Spring Boot
                  
                  La première chose à faire est d'ajouter dans le pom.xml la dépendance du starter Spring Boot pour Spring Data JPA :
                  
                  ```
                  <dependency>
                      <groupId>org.springframework.boot</groupId>
                      <artifactId>spring-boot-starter-data-jpa</artifactId>
                  </dependency>
                  ```
                  
                  Il faut par ailleurs spécifier à Spring Boot quelle type de base de données sera utilisée. Dans notre cas, nous allons faire simple avec H2, une base SQL embarquée.
                  
                  ```
                  <dependency>
                      <groupId>com.h2database</groupId>
                      <artifactId>h2</artifactId>
                  </dependency>
                  ```JPA.





### 1.4 Les tests ...

![alt text](https://github.com/ameniJalali/articleApplication/blob/master/img1.PNG)

![alt text](https://github.com/ameniJalali/articleApplication/blob/master/img2.PNG)
