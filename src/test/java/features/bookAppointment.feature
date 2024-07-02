Feature: CURA health care application test

  Background: 
    Given User navigate to Cura health care application


  Scenario Outline: Book an appoinment
    And User loging to website with "<name>" and "<password>"
    And User select facility as "<facility>"
    And User select Apply for hospital readmission checkbox
    And User select Helth care Program radiobox as Medicaid
    And User select Visit date as "<date>"
    And user add comment as "<comment>"
    When user click on Book Appointment button
    Then Appointment should be sucessfull

    Examples: 
      | name     | password           | facility                     | date       | comment                      |
      | John Doe | ThisIsNotAPassword | Seoul CURA Healthcare Center | 30/07/2024 | I need a healthcare facility |

   