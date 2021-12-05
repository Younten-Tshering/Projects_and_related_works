# frozen_string_literal: true

class CreateWebgroups < ActiveRecord::Migration[6.1]
  def change
    create_table :webgroups do |t|
      t.string :name
      t.string :members

      t.timestamps
    end
  end
end
