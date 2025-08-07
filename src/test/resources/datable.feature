Feature:  data table demo feature

  Scenario Outline: login with valid invalid data

    Given Go to the loginpage
    When enter credentials  <username> and <password>
    And  press the enter
    Then  user navigate to the homepage for valid

    Examples:

    |username|password|status|
    |admin   |admin123|pass  |
    |admin23 |jack233 |failed|
    |admin234|kale34  |failed|