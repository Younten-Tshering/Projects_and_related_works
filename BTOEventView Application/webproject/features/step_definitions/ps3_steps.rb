# frozen_string_literal: true

When('I visit the main site') do
  visit '/'
end

Then('I should see a ps3 index link') do
  expect(page).to have_button('View PS3')
end

When('I click on the ps3 link') do
  click_button('View PS3')
end

Then('I should see Plan of Project') do
  expect(page).to have_content 'Plan of Project'
end

When('I see Project Manager Profile Button') do
  expect(page).to have_link('Project Manager')
end

Then('I click on Project Manager Button') do
  click_link('Project Manager')
end

When('I see Immediate Question') do
  expect(page).to have_content 'Immediate Question'
end

Then('I return back') do
  visit '/'
end
