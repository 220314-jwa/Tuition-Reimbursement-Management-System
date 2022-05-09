### TRMS: Tuition Reimbursement Management System

Tuition Reimbursement Management System is an application which allows employees at a company to submit requests for reimbursement. If the employee decides to take a certification exam or attend a class, the company may reimburse them for the cost after they submit a request. Managers can then go into the application and approve or reject requests.

### SPMS: Story Pitch Management System

Story Pitch Management System is an application which allows authors to submit pitches for stories to the publishing company. They can write a small description of the story they hope to write, and editors can go into the application and approve or reject story pitches based on whether they sound interesting or even suggest changes before approval.

## Technical Requirements

1. Data must be stored and retrieved from a PostgreSQL database (local or AWS).
2. Data access in Java will be performed using JDBC DAOs.
3. HTTP handling in Java will be done using Javalin.
4. Service layers must be fully unit tested using JUnit and Mockito.
5. DAOs are fully unit tested using JUnit.
6. Front end must be written using HTML, CSS, and JavaScript (no libraries/frameworks for JS. Styling libraries like Bootstrap are fine).
7. At least one feature must have an automation test written using Selenium.

## Functional Requirements

[TRMS Specifications](./p1-specs/TRMS.md)

[SPMS Specifications](./p1-specs/SPMS.md)

## Bonus Requirements

1. Use JWTs for session management.
2. Use at least one Cucumber feature file.
3. Use the POM design pattern for your Selenium test(s).
4. Implement file attachments for requests/pitches.
