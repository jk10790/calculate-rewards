                           ## Spring Boot Application to Calculate Rewards for each Transaction ##

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

## Functionality
   
 The application loads a pre-defined list of transactions from a dataset "Transaction_Dataset.txt" and calculates rewards earned 
 for each transaction before displaying the records on the screen. 
 And total rewards for all transactions are also displayed at the end of the table.
 
 New transactions can be added to the list by simply clicking the "Add New Transaction" button on html page.
    ## A pop-up appears and only a price of the transaction needs to be entered.
    ## Note: Any new Transaction added will only show up at the end of the list until the application server is bounced, 
    		 and will be cleared on bounce.
    
## Steps to Run the application

  Clone the repo into your workspace and run the application as spring boot application.
  
  Application can be accessed through 
    [http://localhost:8080/](http://localhost:8080/)
    


# calculate-rewards
