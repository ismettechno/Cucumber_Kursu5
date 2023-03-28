#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | ismExam1 |

    And Click on the element in Dialog
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in Dialog
      | saveButton |

    And Success message should be displayed

    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog Content
      | ismExam1 |

    And Success message should be displayed