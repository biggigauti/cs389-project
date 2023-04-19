# StockFolio - CS389 Project

This project was done in Java using Spring Boot. This web application features dependency injection, SLF4J logging framework, persistent MariaDB database, and JUnit unit testing.

This application was made for the CS389 class at Carroll College.

## How to run this application

Step-by-step instructions for running this applicatin on your machine.

### Clone the application

Assuming that you have git installed on your machine, clone the project to a local directory of your choice:

```terminal
$ git clone https://github.com/biggigauti/cs389-project.git
```

### Set up MariaDB database

In your terminal, use Homebrew to install the following package.

```terminal
$ brew install mariadb
```

Once installed, or if you already have MariaDB installed, you can continue. If you want to log in to the database, do the following:

```terminal
$ mariadb -u admin -p portfolio
```

When prompted for the password, the default password for this project is "admin01".

### MariaDB structure

There are two tables in our database, **app_user** and **stock**.

To list the users, execute this SQL statement:

```sql
MariaDB [portfolio]> select * from app_user;
```

To list the user's stock records, execute this SQL statement:

```sql
MariaDB [portfolio]> select * from stock;
```

### Run the application

Navigate to the directory where you saved this application within your terminal and execute the following:

```terminal
$ ./gradlew bootRun
```

Once executed, open your browser and go to **localhost:8080**.

### Using the application

When the webpage has loaded, you can log in by entering a username on the login page. If you have not signed up already, your username will be created when trying to log in initially.

Once logged in, you can insert stock positions as you wish and they will instantly be persisted to the database.