# Spring in Action 5 Practice
Practice from Spring in Action fifth edition.

## IntelliJ Setup for Lombok
Building Spring projects with Lombok often requires additional settings or the compilation may fail. If the compilation failed, Try these tips:
* Configure the annotation processor for IntellJ to compile. See [Configuring Annotation Processing](https://www.jetbrains.com/help/idea/configuring-annotation-processing.html).
* Check the the [lombok plugin](https://projectlombok.org/setup/intellij) is installed.
* Check if there's latest [lombok release](https://projectlombok.org/download). If you use maven, remove the lombok directory under your ```.m2/Repository/projectlombok/``` directory and build again.

## Chapter 1
* Handling web requests
* Defining the view
* Testing the controller

## Chapter 2
* Creating a controller class
* Displaying information in the view
* Validating form input

## Chapter 3
* Working with JDBC template via ```Repository```
* Defining a RDBMS schema and preloading the data.
* Inserting data with Simple JDBC Insert

## Chapter 4
* User information customization using ```@Entity```.
* Create an user repository to store user information by extending ```CrudRepository```. 
* Write a ```@Service``` as a user repository service by implementing ```UserDetailsService```, which looks up users in the user repository.
* Configure the security options by extending ```WebSecurityConfigurerAdapter```
* Usage example of the prevention of Cross-Site Request Forgery(CSRF).

## Chapter 5
* Configure a data source, using MySQL as an example.
* Configure logging (```WARN```, ```INFO```, ```DEBUG```, etc.)
* Define profile-specific properties.

## Chapter 6
* REST Controller
* Enabling Hyperlinks
* Use Spring Data REST to enable data-backend service.
