#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

Feature: Citizenship Functionality

  Background:  # before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to CitizenShip page

  Scenario Outline: CitizenShip create
    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Success message should be displayed

    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Already exist message should be displayed

    When User delete the "<name>"
    Then Success message should be displayed

    Examples:
      | name     | short    |
      | i7s1U111 | i273s11 |
      | i7s1Ul12 | i72s112  |
      | i7s1Ul13 | i72s113  |
      | i7s1Ul14 | i72s114  |



#testNG dataProvide burada Scenario Outline olarak krşımıza çıkıyor.