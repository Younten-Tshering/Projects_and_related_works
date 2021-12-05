Feature: Viewer Dashboard

    Scenario: Accessing Viewer Dashboard

        When I visit the website
        Then I should see sign in link
        When I click on sign in 
        Then I should see Login
        When I login
        Then I should see Events button
        When I click on Events button
        Then I should see event details
        When I click on show
        Then I should see description
        When I click on sign out
        Then I should see problem sets