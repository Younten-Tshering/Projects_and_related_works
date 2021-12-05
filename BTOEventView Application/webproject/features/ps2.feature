Feature: Test PS2

    Scenario: Get Ps2 Solution

        When I visit the home page
        Then I should see a ps2 index link
        When I click on the ps2 link 
        Then I should see Quotations
        When I should see xml link
        Then I click on xml link
        When I see visit back 
        Then I visit to ps2 index
        When I see sort by date
        Then I click on sort by date
        When I see sort by category
        Then I click on sort by category
        When I see search 
        Then I click on search
        When I see Quotation
        Then I click on back