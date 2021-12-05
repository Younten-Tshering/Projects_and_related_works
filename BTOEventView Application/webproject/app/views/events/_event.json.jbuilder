# frozen_string_literal: true

json.extract! event, :id, :name, :description, :keyword, :time, :duration, :url, :loc_name, :loc_lot, :loc_lat,
              :status, :created_by, :created_at, :updated_at
json.url event_url(event, format: :json)
