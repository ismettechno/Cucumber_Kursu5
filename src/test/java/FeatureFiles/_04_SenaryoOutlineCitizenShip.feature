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

    Scenario: CitizenShip create
      When User a CitizenShip name as "isCS12" short name as "ics12"
      Then Success message should be displayed

      When User a CitizenShip name as "isCS12" short name as "ics12"
      Then Already exist message should be displayed

