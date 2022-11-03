### Creating a docker image tru spring boot plugin ###
./mvnw spring-boot:build-image
or 
mvn spring-boot:build-image to maven already installed on your pc

### Creating native images using spring native images
mvn clean spring-boot:build image

### Create native image using a different pom.xml
mvn -f .\pom.xml clean spring-boot:build-image  

