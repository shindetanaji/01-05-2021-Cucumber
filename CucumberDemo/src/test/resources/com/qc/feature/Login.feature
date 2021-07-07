@LoginPage
Feature: To validate the queue codes login page

@ValidData
Scenario: Validate dashboard page title with valid credentials
	Given Setup browser and launch login page
	And   Enter valid username "queuecodes@gmail.com"
	And   Enter valid password "123456"
	When  Click on signIn button
	Then  User should be on dashboard page "Queue Codes | Dashboard"
	And   User should be logout and browser should be close
	 
@InvalidData	
Scenario Outline: Validate error meaages for email & password with invalid credentials
	Given Setup browser and launch login page
	And   Enter valid username "<userName>" 
	And   Enter valid password "<userPassword>" 
	When  Click on signIn button
	Then  User should be on login page "Queue Codes | Log in"
	And   Validate emailError as "<expEmailError>" and passwordError "<expPassError>"
	And   Browser should be close
  Examples:
  	|	userName		 | userPassword | 				expEmailError 				| 				expPassError  |
  	|					 |			    |			Please enter email.				|Please enter password.		  |
  	|queuecodes@g		 |	123344	    |Please enter email as queuecodes@gmail.com	|Please enter password 123456 |	
  	|queuecodes@gmail.com|  122346 		|											|Please enter password 123456 |
  	|queuecpddes		 |	123456		|Please enter email as queuecodes@gmail.com |							  |
  	|					 |	123456		|				Please enter email  		|							  |
  	|queuecodes@gmail.com|				|										    |Please enter password.       |
  	