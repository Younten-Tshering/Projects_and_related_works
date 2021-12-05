# frozen_string_literal: true

class User < ApplicationRecord
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable, :trackable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :validatable, :confirmable

  belongs_to :role

  acts_as_voter

  before_validation :assign_role
  def assign_role
    self.role = Role.find_by_name('Member') if role.nil?
  end

  def self.searchuser(search)
    if search
      where('lower(email) LIKE lower(?)', "%#{search}%")
    else
      all
    end
  end

  def is_admin?
    role.name == 'Admin'
  end

  def is_manager?
    role.name == 'Admin'
  end

  def is_active?
    User.active == false
  end

  def self.get_users_registered_per_month
    User.find_by_sql("SELECT COUNT(*) as number_of_users_registered, TO_CHAR(created_at, 'Month') AS month from users GROUP BY TO_CHAR(created_at, 'Month') ORDER BY to_date(TO_CHAR(created_at,'Month'),'Month');").map do |row|
      [
        row['month'],
        row.number_of_users_registered.to_i
      ]
    end
  end

  def self.get_users_registered_per_year
    User.find_by_sql("SELECT COUNT(*) as number_of_users_registered, EXTRACT('Year' FROM created_at) AS year from users GROUP BY EXTRACT('Year' FROM created_at)").map do |row|
      [
        row['year'].to_i.to_s,
        row.number_of_users_registered.to_i
      ]
    end
  end
end
