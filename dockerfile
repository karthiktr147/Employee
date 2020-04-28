FROM openjdk:8 
	EXPOSE 8080 
	ADD target/employeemanagement-0.0.1-SNAPSHOT-jar-with-dependencies.jar employeemanagement-0.0.1-SNAPSHOT-jar-with-dependencies.jar
	ENTRYPOINT ["java","-jar","/employeemanagement-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
