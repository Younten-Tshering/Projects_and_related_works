# frozen_string_literal: true

When('I visit the home page') do
  visit '/'
end

Then('I should see a ps2 index link') do
  expect(page).to have_button('View Quotations')
end

When('I click on the ps2 link') do
  click_button('View Quotations')
end

Then('I should see Quotations') do
  expect(page).to have_content 'Quotations'
end

When('I should see xml link') do
  expect(page).to have_link('XML')
end

Then('I click on xml link') do
  click_link('XML')
end

When('I see visit back') do
  visit '/'
end

Then('I visit to ps2 index') do
  click_button('View Quotations')
end

When('I see sort by date') do
  expect(page).to have_link('Sort by date')
end

Then('I click on sort by date') do
  click_link('Sort by date')
end

When('I see sort by category') do
  expect(page).to have_link('Sort by category')
end

Then('I click on sort by category') do
  click_link('Sort by category')
end

When('I see search') do
  expect(page).to have_link('SEARCH')
end

Then('I click on search') do
  click_link('SEARCH')
end

When('I see Quotation') do
  expect(page).to have_content 'Quotations'
end

Then('I click on back') do
  click_link('BACK')
end
