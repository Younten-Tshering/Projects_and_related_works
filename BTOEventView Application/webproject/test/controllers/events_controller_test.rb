# frozen_string_literal: true

require 'test_helper'

class EventsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @event = events(:one)
  end

  test 'should get index' do
    get events_url
    assert_response :success
  end

  test 'should get new' do
    get new_event_url
    assert_response :success
  end

  test 'should create event' do
    assert_difference('Event.count') do
      post events_url,
           params: { event: { description: @event.description, duration: @event.duration, keyword: @event.keyword,
                              loc_lat: @event.loc_lat, loc_lot: @event.loc_lot, loc_name: @event.loc_name, name: @event.name, status: @event.status, time: @event.time, url: @event.url, userid: @event.userid } }
    end

    assert_redirected_to event_url(Event.last)
  end

  test 'should show event' do
    get event_url(@event)
    assert_response :success
  end

  test 'should get edit' do
    get edit_event_url(@event)
    assert_response :success
  end

  test 'should update event' do
    patch event_url(@event),
          params: { event: { description: @event.description, duration: @event.duration, keyword: @event.keyword,
                             loc_lat: @event.loc_lat, loc_lot: @event.loc_lot, loc_name: @event.loc_name, name: @event.name, status: @event.status, time: @event.time, url: @event.url, userid: @event.userid } }
    assert_redirected_to event_url(@event)
  end

  test 'should destroy event' do
    assert_difference('Event.count', -1) do
      delete event_url(@event)
    end

    assert_redirected_to events_url
  end
end
