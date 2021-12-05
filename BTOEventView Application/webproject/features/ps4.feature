Feature: Test PS4

    Scenario: check user management model

        When I visit the main page
        Then I should see a ps4 index link
        When I click on the ps4 link 
        Then I should see Define your user data model
        When I see User Management doc link
        Then I close
