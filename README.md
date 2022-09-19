# myBabbelCodingAssignment

This project was developed using Java, Maven, Cucumber, junit, and Selenium.
The framework - BDD

##### Execution Step
You can use the following command to clone my project from GitHub to you local machine:  <br />
Git clone https://github.com/Hozhalan/myBabbelCodingAssignment.git

##### After cloning the project
To run a headless execution, use the following maven command: ->  <br /> mvn test "-DheadlessMode=true" 
To standard execution, use the following maven command: -> <br /> mvn clean install

##### Assumption :
All the test executions were executed assuming the user had already registered in the "amazon".

##### NOTE
Typically, we do not perform test automation directly on the production webpage, but this automation testing was completed by using the actual amazon.com webpage. As a result, I encountered the following problem: <br /> <br />

I automated two test scenarios, and my expected result for those two test scenarios wasto check whether the user landed on the "shipping and payment" webpage only because I was unable to proceed to payment with test data/invalid values because of Amazon.com's identifying it as a suspected activity and suspending the account due to Amazon.com's strict security concerns. Therefore, my testing was limited to a certain webpage with two test scenarios.
