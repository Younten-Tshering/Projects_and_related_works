Feature: Project Manager Dashboard

    Scenario: Accessing Project Manager Dashboard

        When I visit the website link
        Then I should see sign in url
        When I click on sign in url
        Then I should see Log in 
        When I log in to system as project manager
        Then I should see Events 
        When I click on Events 
        Then I should see event detail
        When I click on show url
        Then I should see description of event
        Then I click on Back url
        When I see New Event url 
        Then I click on new event url 
        Then I insert data and create event 
        When I click on sign out url
        Then I should see home page