# Blue Energy Meter Read Application

Basic implementation of a spring boot meter read application using 3 rest end points
* GET - createCustomer(String customerId) // creates customer within the database
* POST - submitMeterRead(MeterRequest request) // using the schema provided
* GET - getReadings(String customerId) // returns a JSON object of the readings

### Installing

- Initialise the mySql database with the provided blueEnergy.sql file
- Build the application with maven
- Run the application with your given tool
- Using the provided localhost.postman_collection.json file post some requests to the service

### Changes from original schema

- Changed the provided ISO standard date to use millisecond 
- MPXN numbers must be either 11 or 21 in length as thats the standard for GAS and ELECTRIC meters (From what I researched)

### What I would have done better

- More unit testing im aware its a little thin on the ground but I valued working software over testing with my time constraint
- Integration testing
- Additional validation around duplicate inserts as it currently doesn't stop them being double inserted
- Additional validation around MPXN numbers as im aware there is a wide variety of meanings behind the sections of MPRN and MPAN numbers