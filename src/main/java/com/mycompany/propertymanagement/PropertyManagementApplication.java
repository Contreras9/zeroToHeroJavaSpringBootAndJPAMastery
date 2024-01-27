package com.mycompany.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementApplication.class, args);
	}

}

//Layered Architecture

//Controller Layer ---> Service Layer ---> Repository Layer ---> Database

//Client ---> Controller ---> DTO ---> Converter ---> Service(ServiceImplementation) ---> convertEntityToDTO ---> Repository(DTO) ---> Database

//Controller Layer has a responsibility to take the request from the client, which is coming via HTTP protocol in the URL.
//Service Layer has the responsibility to do some business logic.
//Repository Layer will have the responsibility to connect to the database and save the information in the database.



//Client --> Controller(Get allProperties) --> Service --> Repository --> Database --> Entity --> Converter(List<PropertyEntity>) --> List(PropertyDTO) --> Controller