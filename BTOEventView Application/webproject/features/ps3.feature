Feature: Test PS3

    Scenario: Get Ps3 Solution

        When I visit the main site
        Then I should see a ps3 index link
        When I click on the ps3 link 
        Then I should see Plan of Project
        When I see Project Manager Profile Button
        Then I click on Project Manager Button
        When I see Immediate Question
        Then I return back
