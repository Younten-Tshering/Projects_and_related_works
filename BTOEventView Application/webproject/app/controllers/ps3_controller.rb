# frozen_string_literal: true

class Ps3Controller < ApplicationController
  def index
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end

  def user1
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end

  def user2
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end

  def user3
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end
end
