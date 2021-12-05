Feature: Test PS1

    Scenario: Get Ps1 Solution

        When I visit the site
        Then I should see a scrape index link
        When I click on the link 
        Then I should see world news
        When I visit the site again
        Then I should see a divide index link
        When I click on the divide link
        Then I should see divide Solution