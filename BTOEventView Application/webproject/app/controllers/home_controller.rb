# frozen_string_literal: true

class HomeController < ApplicationController
  def index
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end
end
