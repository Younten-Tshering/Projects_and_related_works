# frozen_string_literal: true

class ApplicationController < ActionController::Base
  helper_method :is_admin?
  helper_method :is_active?
  helper_method :is_manager?

  def is_admin?
    current_user && current_user.role.name == 'Admin'
  end

  def is_active?
    current_user && current_user.user.active == false
  end

  protect_from_forgery

  before_action :update_sanitized_params, if: :devise_controller?

  protected

  def update_sanitized_params
    devise_parameter_sanitizer.permit(:sign_up,
                                      keys: %i[uid email password first_name last_name organazation designation])

    devise_parameter_sanitizer.permit(:account_update,
                                      keys: %i[uid email password first_name last_name organazation designation])
  end
end
