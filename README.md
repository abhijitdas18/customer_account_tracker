# customer_account_tracker



Two Controllers:
1. Customer
2. Account

The Endpoints for Customer:
1. To create a new Customer details
POST : http://localhost:8080/app/customer/addCustomer
2. To display all customers
GET : http://localhost:8080/app/customer/customers
3. To display a customer by a customer Id
GET : http://localhost:8080/app/customer/customers/101
4. To delete a customer by customer Id
DELETE : http://localhost:8080/app/customer/customers/101


The Endpoints for Account:
1. To create a new Account details
POST : http://localhost:8080/account/addAccount
2. To display all accounts
GET : http://localhost:8080/account/accounts
3. To display an account by an account number
GET : http://localhost:8080/account/accounts/12345
4. To get all account details for a customer Id
GET : http://localhost:8080/account/accounts/customers/12345
5. To update an account based on account number
PUT : http://localhost:8080/account/accounts/12345
6. To do fund transfer for account1 to account2
POST: http://localhost:8080/account/accounts/fundTransfer

Unit Test Cases are added for service, repository layers.
