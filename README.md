                           ## Spring Boot Application to Calculate Rewards for each Transaction ##

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

## Functionality
   
 The application loads a pre-defined list of transactions from a dataset "Transaction_Dataset.txt" and calculates rewards earned 
 for each transaction before displaying the records on the screen
 
New transactions can be added to the list by simply clicking the "Add New Transaction" button on html page.
    ## A pop-up appears and only a price of the transaction needs to be entered.
    
## Steps to Run the application

  Clone the repo into your workspace and run the application as spring boot application.
  
  Application can be accessed through 
    [http://localhost:8080/transactions](http://localhost:8080/transactions)
    
    
## Note: Application only has test cases for the reward calculation business logic currently, need to add more cases

# calculate-rewards
