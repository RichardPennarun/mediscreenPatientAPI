# MediscreenPatientApi

An API with 1 entity, the patient, to manipulate its demographics.

You will be able to get all patients, to get one patient by its id, to create a new patient, to update demographics for this patient or to delet it.

All is saved on mysql and packed in Docker.

API exposed port : 8081


##### Prerequisites
- Java 11
- SpringBoot 2.5.5
- Mysql 8.0
- Docker


##### Running App
Please download : 
https://github.com/RichardPennarun/mediscreenPatientAPI/archive/refs/heads/main.zip

Open your terminal window, go to the root folder and run this 2 lines in this order :
- docker build -t mediscreenpatientapi .
- docker-compose up -d
Data are provided in it.


##### Testing
The app has a Jacoco test coverage of 94 %
