Feature: Get list players

  Scenario: Get list players in the Admin Panel
    When Open page "http://test-app.d6.dev.devcaz.com/admin/login"
    And Input login "admin1"
    And Input password "[9k<k8^z!+$$GkuP"
    And Click button

    When Title shows it the Admin Panel
    And Click on the option in the menu
    And Click on the option in the Users menu
    Then Show list users the Dashboard


