Feature: PIM
As an OrangeHRM admin user,
I should be able to access PIM feature,
So that I can easily manage employee records.

Scenario: User log in into Orange HRM application as Admin user
Given Initialize browser
And User navigate to "https://opensource-demo.orangehrmlive.com/index.php/dashboard" site
When User enters "Admin" and "admin123" and Logs In 
Then User successfully logged into OrangeHRM application

Scenario: Add New Employee
Given User navigate to PMI Tab
And User click on Add Employee in PMI Tab
And User Enter all details for adding new Employee
When User Click on save button to add new Employee
Then New Employee has been addess successfully


