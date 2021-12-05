# frozen_string_literal: true

FactoryBot.define do
  factory :viewer, class: User do
    email { 'st121799@ait.asia' }
    password { 'web888' }
    password_confirmation { 'web888' }
  end
end
