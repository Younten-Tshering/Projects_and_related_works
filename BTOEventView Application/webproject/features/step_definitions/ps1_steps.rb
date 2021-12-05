# frozen_string_literal: true

When('I visit the site') do
  visit '/'
end

Then('I should see a scrape index link') do
  expect(page).to have_button('Get Articles')
end

When('I click on the link') do
  click_button('Get Articles')
end

Then('I should see world news') do
  expect(page).to have_content 'NYTimes'
end

When('I visit the site again') do
  visit '/'
end

Then('I should see a divide index link') do
  expect(page).to have_button('Check')
end

When('I click on the divide link') do
  click_button('Check')
end

Then('I should see divide Solution') do
  expect(page).to have_content 'Explanation'
end
