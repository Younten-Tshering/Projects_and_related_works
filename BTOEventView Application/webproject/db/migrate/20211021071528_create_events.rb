# frozen_string_literal: true

class CreateEvents < ActiveRecord::Migration[6.1]
  def change
    create_table :events do |t|
      t.string :name
      t.text :description
      t.string :keyword
      t.datetime :time
      t.integer :duration
      t.string :url
      t.string :loc_name
      t.decimal :loc_lot
      t.decimal :loc_lat
      t.string :status
      t.integer :created_by

      t.timestamps
    end
  end
end
