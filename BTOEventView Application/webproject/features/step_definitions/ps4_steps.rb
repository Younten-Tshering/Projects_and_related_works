# frozen_string_literal: true

When('I visit the main page') do
  visit '/'
end

Then('I should see a ps4 index link') do
  expect(page).to have_button('View PS4')
end

When('I click on the ps4 link') do
  click_button('View PS4')
end

Then('I should see Define your user data model') do
  expect(page).to have_content 'Define your user data model'
end

When('I see User Management doc link') do
  expect(page).to have_link('User Management Doc')
end

Then('I close') do
  visit '/'
end
