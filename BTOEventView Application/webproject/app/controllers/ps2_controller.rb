# frozen_string_literal: true

class Ps2Controller < ApplicationController
  def quotations
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end

    if params[:quotation]
      @quotation = Quotation.new(quotation_params)

      @quotation.category = if params[:new_category][:id] == '' || params[:new_category][:id].nil?
                              params[:quotation][:category]
                            # puts 'category:' + @quotation.category.to_s + 'params:' + params[:category]
                            else
                              params[:new_category][:id]
                              # puts 'new_category:' + @quotation.category.to_s + 'params:' + params[:new_category][:id]
                            end

      if @quotation.save
        flash[:notice] = 'Quotation was successfully created.'
        @quotation = Quotation.new
      end
    else
      @quotation = Quotation.new
    end

    cookies.delete :ids if params[:clear]

    if params[:id]
      cookies.permanent[:ids] = if cookies.permanent[:ids].blank?
                                  params[:id]
                                else
                                  "#{cookies.permanent[:ids]} #{params[:id]}"
                                end
    end

    @id_array = cookies.permanent[:ids].blank? ? nil : cookies.permanent[:ids].split(' ')

    @quotations = if params[:sort_by] == 'date'
                    Quotation.where.not(id: @id_array).order(:created_at)
                  else
                    Quotation.where.not(id: @id_array).order(:category)
                  end

    @all_quotations = Quotation.all
    respond_to do |format|
      format.html
      format.json { render json: @all_quotations }
      format.xml { render xml: @all_quotations.map(&:as_json).to_xml }
    end
  end

  def quotationssearch
    @group = if Webgroup.count.zero?
               Webgroup.create(name: 'Web 8',
                               members: 'Younten,Sai Preetham Kamishetty, Hekmat')
             else
               Webgroup.first
             end

    @id_array = cookies.permanent[:ids].blank? ? nil : cookies.permanent[:ids].split(' ')
    @quotations = Quotation.where.not(id: @id_array).search(params[:search])
  end

  def importxml
    # ##print(params)
    require 'open-uri'
    require 'nokogiri'

    @page = params[:page_link].end_with?('.xml') ? params[:page_link] : "#{params[:page_link]}.xml"

    begin
      doc = Nokogiri::XML(URI.open(@page))
    rescue Errno::ENOENT => e
      flash.alert = 'Not a valid url'
    end

    doc&.css('object')&.each do |node|
      children = node.children

      Quotation.create(
        author_name: children.css('author-name').inner_text,
        category: children.css('category').inner_text,
        quote: children.css('quote').inner_text
      )
    end

    redirect_to ps2_quotations_path
  end

  private

  def quotation_params
    params.require(:quotation).permit(:author_name, :category, :quote, :new_category)
  end
end
