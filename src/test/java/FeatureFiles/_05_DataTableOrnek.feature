Feature: DataTable Ornek

  Scenario: Users List
    When Write username "ismet"
    And Write username and Password "ismet" and "1234"
    And Write username as DataTable
      | ismet  |
      | mehmet |
      | ayşe   |
      | kaya   |

    And Write username and password as DataTable
      | ismet  | 1234 |
      | mehmet | 2324 |
      | ayşe   | 4545 |
      | kaya   | 4554 |