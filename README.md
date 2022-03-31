# Class Schedule

## A student's weekly class schedule

This application aims to help students keep track of their classes for each day 
of the week by being able to list the classes they will have in each 
particular day. This application is for students who take many classes per 
week and helps them remember what classes they have each day. This 
project is of interest to me because as a student, I have difficulty 
remembering all the classes I need to attend per day and this application
would ensure that I don't miss any of my classes. 

**User stories:**
- As a user, I want to be able to add a class to my weekly schedule
- As a user, I want to be able to remove a class from my weekly schedule
- As a user, I want to be able to add or remove multiple classes from my weekly schedule
- As a user, I want to be able to view my updated schedule every time I remove/add a class
- As a user, I want to be able to print my complete schedule
- As a user, I want to be able to save my schedule to file 
- As a user, I want to be able to be able to load my schedule from file

**Phase 4: Task 2**

Here is an example of what the user stories being logged into the console after the program runs looks like.

Thu Mar 31 09:02:41 PDT 2022
Class CPSC110 added to Monday

Thu Mar 31 09:02:52 PDT 2022
Class CPSC121 added to Monday

Thu Mar 31 09:02:58 PDT 2022
Class CPSC210 added to Thursday

Thu Mar 31 09:03:06 PDT 2022
Class CPSC121 removed from Monday

**Phase 4: Task 3**

If I had more time to work on refactoring my project, I would:
- Refactor each of the remove class day methods into just one remove class method in the WeeklyClasses class, like I did with the add class method
- Refactor the GUI into more than one class to increase cohesion and follow the single responsibility principle
- Create more abstract classes and interfaces to extend from to reduce repeated code in the model and ui packages

*Source Attribution: The code used in this project is based on the TellerApp, the Json Serialization Demo, and the LabelChanger codes provided in class.*
 