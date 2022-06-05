Feature: Authorization user in system

  Scenario: Authorization user
    When Open page "http://test-app.d6.dev.devcaz.com/admin/login"
    And Input login "admin1"
    And Input password "[9k<k8^z!+$$GkuP"
    And Click button
    Then Title shows it the Admin Panel
