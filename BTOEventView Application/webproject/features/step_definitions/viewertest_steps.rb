# frozen_string_literal: true

When('I visit the website') do
  # Write code here that turns the phrase above into concrete actions
  visit '/'
end

Then('I should see sign in link') do
  # Write code here that turns the phrase above into concrete actions
  expect(page).to have_link('Sign in')
end

When('I click on sign in') do
  # Write code here that turns the phrase above into concrete actions
  click_link('Sign in')
end

Then('I should see Login') do
  # Write code here that turns the phrase above into concrete actions
  expect(page).to have_content 'Log in'
end

When('I login') do
  # Write code here that turns the phrase above into concrete actions
end

Then('I should see Events button') do
  # Write code here that turns the phrase above into concrete actions
end

When('I click on Events button') do
  # Write code here that turns the phrase above into concrete actions
end

Then('I should see event details') do
  # Write code here that turns the phrase above into concrete actions
end

When('I click on show') do
  # Write code here that turns the phrase above into concrete actions
end

Then('I should see description') do
  # Write code here that turns the phrase above into concrete actions
end

When('I click on sign out') do
  # Write code here that turns the phrase above into concrete actions
end

Then('I should see problem sets') do
  # Write code here that turns the phrase above into concrete actions
end
