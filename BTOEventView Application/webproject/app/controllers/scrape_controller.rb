# frozen_string_literal: true

require 'nokogiri'
require 'open-uri'
class ScrapeController < ApplicationController
  def index
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end

    @html = URI.open('https://www.nytimes.com/world')
    @html2 = URI.open('https://www.bangkokpost.com/world')

    @d = Nokogiri::HTML5.parse(@html)
    @d2 = Nokogiri::HTML5.parse(@html2)

    @outt = []
    @outl = []
    @outi = []
    @outt2 = []
    @outl2 = []
    @outi2 = []

    @d.css("h2 a[href*='world']").each do |t|
      @outt.push(t.text)
      @outl.push("https://www.nytimes.com#{t['href']}")
    end
    @d.css("figure > a[href*='world'] > img").each do |i|
      @outi.push(i['src'])
    end
    @d2.css("figure > a[href*='world'] > img").each do |j|
      @outi2.push(j['src'])
      @outt2.push(j['alt'])
    end
    @d2.css("figure > a[href*='world']").each do |k|
      @outl2.push("https://bangkokpost.com#{k['href']}")
    end
  end
end
