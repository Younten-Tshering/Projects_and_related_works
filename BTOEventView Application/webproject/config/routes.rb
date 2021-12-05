# frozen_string_literal: true

Rails.application.routes.draw do
  get 'ps6/index'
  get 'ps5/index'
  resources :events do
    member do
      patch 'upvote', to: 'events#upvote'
      delete :purge_images
    end
  end
  get 'ps4/index'
  devise_for :users
  get 'ps3/index'
  get 'ps2/index'

  get '/searchevent', to: 'events#searchevent'

  get 'ps4/index'
  post 'ps4/index'
  get 'scrape/index'
  root 'home#index'
  get 'home/index'
  get 'ps2/quotations'
  post 'ps2/quotations'
  post 'ps3/index'
  get 'ps3/user1'
  post 'ps3/user1'
  get 'ps3/user2'
  post 'ps3/user2'
  get 'ps3/user3'
  post 'ps3/user3'

  get 'ps4/admin'
  post 'ps4/admin'

  get 'ps4/ban_users'
  post 'ps4/ban_users'

  get 'ps4/user_role'
  post 'ps4/user_role'

  get 'ps4/ban_users', to: 'ps4#ban_users'

  get 'ps4/view'
  post 'ps4/view'

  get 'ps4/stat'
  post 'ps4/stat'

  get 'ps5/index'
  post 'ps5/index'

  get 'ps6/index'
  post 'ps6/index'

  get 'ps4/userp'
  post 'ps4/userp'

  get 'ps2/quotationssearch'
  get 'ps2/importxml' => 'ps2#importxml'
  # get ({'/divide' => 'divide#index'})
  get({ '/calculate' => 'divide#calculate' })

  get 'ps2/quotationssearch'
  get 'ps2/importxml' => 'ps2#importxml'

  resources :home do
    match '/scrape', to: 'scrape#index', via: :post, on: :collection
    match '/divide', to: 'divide#index', via: :post, on: :collection
    match '/ps2', to: 'ps2#index', via: :post, on: :collection
  end

  delete 'events/:id/purge', to: 'images#purge', as: 'purge_image'
end
