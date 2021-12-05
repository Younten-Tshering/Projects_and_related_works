# frozen_string_literal: true

class DivideController < ApplicationController
  def index
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end

  def calculate
    @numerator = params[:numerator].to_i
    @denominator = 0

    logger.warn 'The next step is to divide by zero!'
    @output = (@numerator / @denominator)
    logger.error 'divided by zero!'
    @output
  end
  helper_method :calculate
end
