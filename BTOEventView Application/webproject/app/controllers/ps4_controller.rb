# frozen_string_literal: true

class Ps4Controller < ApplicationController
  def index
    # @group = if Webgroup.count.zero?
    #            Webgroup.create(name: 'Web 8',
    #                            members: 'Younten,Sai Preetham Kamishetty, Hekmat')
    #          else
    #            Webgroup.first
    #          end
  end

  def admin; end

  def manage_users; end

  def ban_users
    # @users = User.where(id > 0).order('id')
    @users = User.searchuser(params[:search])

    if params[:id]
      @bann = User.where(id: params[:id])[0]
      if @bann.active?
        @bann.update(active: false)
      else
        @bann.update(active: true)
      end
      @bann.save
    end
  end

  def user_role
    if params[:id]
      @userrole = User.where(id: params[:id])[0]
      case @userrole.role_id
      when 25
        @userrole.update(role_id: 26)
      when 26
        @userrole.update(role_id: 25)
      end
      @userrole.save
    end
  end

  def view_stats
    @user_per_month = User.get_users_registered_per_month
    @user_per_year = User.get_users_registered_per_year
  end
end
