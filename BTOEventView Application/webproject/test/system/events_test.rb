# frozen_string_literal: true

require 'application_system_test_case'

class EventsTest < ApplicationSystemTestCase
  setup do
    @event = events(:one)
  end

  test 'visiting the index' do
    visit events_url
    assert_selector 'h1', text: 'Events'
  end

  test 'creating a Event' do
    visit events_url
    click_on 'New Event'

    fill_in 'Description', with: @event.description
    fill_in 'Duration', with: @event.duration
    fill_in 'Keyword', with: @event.keyword
    fill_in 'Loc lat', with: @event.loc_lat
    fill_in 'Loc lot', with: @event.loc_lot
    fill_in 'Loc name', with: @event.loc_name
    fill_in 'Name', with: @event.name
    fill_in 'Status', with: @event.status
    fill_in 'Time', with: @event.time
    fill_in 'Url', with: @event.url
    fill_in 'Userid', with: @event.userid
    click_on 'Create Event'

    assert_text 'Event was successfully created'
    click_on 'Back'
  end

  test 'updating a Event' do
    visit events_url
    click_on 'Edit', match: :first

    fill_in 'Description', with: @event.description
    fill_in 'Duration', with: @event.duration
    fill_in 'Keyword', with: @event.keyword
    fill_in 'Loc lat', with: @event.loc_lat
    fill_in 'Loc lot', with: @event.loc_lot
    fill_in 'Loc name', with: @event.loc_name
    fill_in 'Name', with: @event.name
    fill_in 'Status', with: @event.status
    fill_in 'Time', with: @event.time
    fill_in 'Url', with: @event.url
    fill_in 'Userid', with: @event.userid
    click_on 'Update Event'

    assert_text 'Event was successfully updated'
    click_on 'Back'
  end

  test 'destroying a Event' do
    visit events_url
    page.accept_confirm do
      click_on 'Destroy', match: :first
    end

    assert_text 'Event was successfully destroyed'
  end
end
