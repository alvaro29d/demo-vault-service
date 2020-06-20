# DEMO VAULT SERVICE

This project explores the library `spring-cloud-starter-vault-config`.

## Running the application

Vault has support for spring profiles, you can run this application without a profile or with a `prod` profile 
and the application will load a different set of properties. 

#### Setting the environment

First [install vault](https://learn.hashicorp.com/vault/getting-started/install) on your environment.

Then use the script `scripts/start-vault.sh`, this will start a vault server with the following configuration:

| Paths                              | default       | prod              |
|------------------------------------|---------------|-------------------|
| **services**/demo-vault/props.name | nameFromVault | prodNameFromVault |
| **shared**/endpoints/eureka.host   | eurekaHost    | prodEurekaHost    |
| **shared**/endpoints/eureka.port   | 8761          | 8761              |

#### Run demo-valut-service

```shell script
./mvnw clean install
./mvnw spring-boot:run
```

Go to the following URL's to see the loaded properties
>http://localhost:8080/props  
>http://localhost:8080/value

You can also find these values in the console logs.

To use the profile `prod`, use the command:
```shell script
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```
