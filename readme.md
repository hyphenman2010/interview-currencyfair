# Project for CurrencyFair Interview

This is a Springboot base project for the interview coding test.

## Setup the project and run locally in IDE 
The following items should be installed in your system:
* Java 8 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog.
  If m2e is not there, just follow the install process here: https://www.eclipse.org/m2e/
* PostMan to POST to the consume-message end point
* Browser to GET and render the html to view the result

  
  
### Steps:

1) On the command line, clone the project

    `git clone https://github.com/spring-projects/spring-petclinic.git`
    
  
2) Inside Eclipse

    `File -> Import -> Maven -> Existing Maven project`
    
3) Right click on project

    `Run As -> Maven install`
   
4) Run the application main method by right clicking on **org.ivanman.interview.InterviewApplication**

    `Run As -> Java Application`


### Api-EndPoint, in total 5:
1)  Url: http://localhost:8081/publish

    Using:  PostMan
    Method: POST
    Payload: { "userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP",
			   "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471,
			   "timePlaced" : "24-JAN-18 10:27:44", "originatingCountry" : "FR"}
	Remark:  This is to submit an order request.


2)  Url: http://localhost:8081/order_requests.html

    Using:  Browser
    Method: GET
    Remark: This is to get the html which list the posted order requests
    

3)  Url: http://localhost:8081/orderRequests

    Using:  Browser or PostMan
    Method: GET
    Remark: This is to get the Json of the posted order requests

    

4)  Url: http://localhost:8081/order_results.html

    Using:  Browser
    Method: GET
    Remark: This is to get the html which list the posted order results
    

5)  Url: http://localhost:8081/orderResults

    Using:  Browser or PostMan
    Method: GET
    Remark: This is to get the Json of the posted processed order results.




## Database configuration

This project uses an in-memory database (H2) which
gets **populated at startup with 1 dummy order request record.** 

So in case you cannot post anything, at least you should be able to one dummy record via **http://localhost:8081/order_requests.html**
 



## Project Structure

The **Main** Class
* org.ivanman.interview.InterviewApplication

The **org.ivanman.interview.messaging** package
* The endpoint for Message Consumption, after receiving the OrderRequest json (Producer.java) it will put the message to a Queue, and
  the consumer (Consumer.java) will pick it up and process it. "Process it" means the order is filled, and an OrderResult is created. 
  
  
  The final result is, an OrderRequest and OrderResult object are produced, and both are saved to the H2 database.
  In short, a typical producer and consumer pattern  

The **org.ivanman.interview.model** package
* The entity class base class, which provides the id column for JPA to play around

The **org.ivanman.interview.order** package
* Please note I used a feature-based project structure, which means I put the business-related files (The order) under that same pacakge.
  As versus to another approach, which puts technical-related files together (like having a controller/repository package)
  
  This is the endpoint for the front-end to GET the OrderRequest and OrderResult
  
The **org.ivanman.interview.system** package
* To put all the SpringBoot project-wise related file here, for example logging, cache, default error handling.


## The Testing
Using standard Junit and Mockito approach
Please be noted that by no mean the test cases are suffice, I should have consider more edge cases, better code coverage etc etc.....
But for now lets keep it simple and leaving room for improvement :)
 


