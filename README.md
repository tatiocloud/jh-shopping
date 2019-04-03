# jh-shopping

##Criteria
    1) Find the Reduced Pricing from List of Products for a Category.
    2) Based on label, format the pricingLabel for the output.

## Assumptions.

    1) Formating is Based on the labelForFormat provided in the request,otherwise defaulted to true.
    2) Unit and Integration Tests provided at high level and use of functional programming is used.

## Can this be improved, Yes all validations can be improved and can be used as functions in java8.

## Jackson JSON has been used where ever neccesary.
     
## How to run.
This is maven based Spring boot application. I use Intellij, so open the project in the Intellij/Eclipse as maven
project.

1) mvn clean install -> this should run all the tests and then build a jar.
2) run the jar from command line using.
     java -jar target/jh-shopping-1.0-SNAPSHOT.jar


####Possible Uses case you run using the different priceLabels

1) http://localhost:8080/v1/categories/100/products  
   Description : this will default to ShowWasNow
   
2) http://localhost:8080/v1/categories/100/products?priceLabel=ShowWasThenNow 
   Description : this will  format to ShowWasThenNow

3) http://localhost:8080/v1/categories/100/products?priceLabel=ShowPercDiscount 
      Description : this will  format to to discount feature mentioned in the document.
