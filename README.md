# Slam Book Backend

This application is the backend for Slam book application.

## Installation


```bash
./mvnw clean spring-boot:run
```

## Database

This application is uses mysql for backend.

## Security

This application uses JWT for authentication and authorization.

## License
[MIT](https://choosealicense.com/licenses/mit/)

##Using Docker for mysql
#docker run --name slam-sql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=ashwani -e MYSQL_PASSWORD=password  -e MYSQL_DATABASE=slam  -d mysql/mysql-server:5.7

#connect to sql
docker exec -it mysql101 mysql -u root -p

#create a user
CREATE USER 'ashwani'@'%' IDENTIFIED BY 'password';

#give all privileges to ashwani
GRANT ALL PRIVILEGES ON * . * TO 'ashwani'@'%';

#connect to sql
docker exec -it mysql101 mysql -u ashwani -p

#display mysql details
docker inspect mysql101

#List containers
docker container ls

#Stop container
docker stop container-name


 
