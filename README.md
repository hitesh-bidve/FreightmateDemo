# FreightmateProTask

### Application development environment

The application is developed using
	
	1. Java 11
	2. SpringBoot
	3. Junit + Mockito
	4. Swagger_2

### How to run the application with maven build (Recommended)

To run the application the following steps need to processed
	
	./mvnw clean install	 -DskipTests  -- if test cases run not required
	./mvnw clean install                  -- with test case
	
The above command will build the application

	java -jar target/FreightmateProTask-0.0.1-SNAPSHOT.jar

The above command start the application on `8080` port.


### Database
Below Command for create table
		
		CREATE TABLE `suburb` (`id` bigint NOT NULL AUTO_INCREMENT,`post_code` varchar(6) DEFAULT NULL,`suburb_name` varchar(255) DEFAULT NULL,PRIMARY KEY (`id`),UNIQUE KEY `UK_re1whmflnlt10163p7b95sdr7` (`suburb_name`)
		);
	
	
	
 	
Below Command for insert data

	INSERT INTO `suburbapp`.`suburb`
	(`id`,
	`post_code`,
	`suburb_name`)
	VALUES
	(<{id: }>,
	<{post_code: }>,
	<{suburb_name: }>);
	
Below Command for retrieve all data
	
	SELECT `suburb`.`id`,
    `suburb`.`post_code`,
    `suburb`.`suburb_name`
	FROM `suburbapp`.`suburb`;
		

### Assumption for the application
The application is developed based on two assumptions

	1. Please note that all parameters in JSON body is required.
	
	

### Testing application with sample data
Below curl code for post data into database	

	curl --location --request POST 'http://localhost:8080/freightApp/v1/addSuburbs' --header 'Content-Type:   	application/json' --data-raw '{"suburbName":"Dinoli Surat","postCode":"394210"}'

Below url for retrieve data of postcode from database
	
	curl localhost:8080/freightApp/v1/postcode/Dindoli Surat
	
Below url for retrieve data of suburbs from database

	curl localhost:8080/freightApp/v1/suburbs/394210
	

### How to run without compile (Not Recommended)	

A pre-compiled jar file is given in `lib` directory. The application can be run using that jar too.

	java -jar lib/FreightmateProTask-0.0.1-SNAPSHOT.jar

	