# frozen_string_literal: true

require 'nokogiri'
require 'open-uri'

class HomeController < ApplicationController
  def index
    @html = URI.open('https://www.worldtoilet.org/news/')

    @d = Nokogiri::HTML5.parse(@html)

    @outtt = []
    @outll = []
    @outii = []
    @outii2 = []
    @i = 0

    @d.css('div.post-thumbnail a').each do |t|
      @outll.push(t['href'])
    end

    @d.css("div.post-thumbnail a[href*='world'] img").each do |g|
      @outii.push(g['src'])
    end

    @outii.each do |f|
      @i += 1

      @outii2.push(f) if @i.odd? == false
    end

    @d.css('div.blog-content h2').each do |h|
      @outtt.push(h.text)
    end

    @outtt.pop(2)

    # @d.css("div.featured-photo").each do |i|
    #   @outi.push(i)
    # end
  end

  def problemset
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end
  end
end
