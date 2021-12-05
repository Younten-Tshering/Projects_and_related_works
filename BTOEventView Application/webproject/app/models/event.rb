# frozen_string_literal: true

class Event < ApplicationRecord
  has_many_attached :images

  has_one_attached :qr_code

  include Rails.application.routes.url_helpers
  require 'rqrcode'
  #  method to generate QR Code
  after_create :generate_qr

  def generate_qr
    qr_url = url_for(controller: 'events',
                     action: 'show',
                     id: id,
                     only_path: false,
                     host: 'localhost:3000',
                     source: 'from_qr')

    qrcode = RQRCode::QRCode.new(qr_url)

    png = qrcode.as_png(
      bit_depth: 1,
      border_modules: 4,
      color_mode: ChunkyPNG::COLOR_GRAYSCALE,
      color: 'black',
      file: nil,
      fill: 'white',
      module_px_size: 6,
      resize_exactly_to: false,
      resize_gte_to: false,
      size: 120
    )

    image_name = SecureRandom.hex

    IO.binwrite("tmp/#{image_name}.png", png.to_s)

    blob = ActiveStorage::Blob.create_after_upload!(
      io: File.open("tmp/#{image_name}.png"),
      filename: image_name,
      content_type: 'png'
    )

    qr_code.attach(blob)
  end

  acts_as_votable

  def self.searchevent(searchevent)
    if searchevent
      where(['lower(name) LIKE lower(?) OR lower(loc_name) LIKE lower(?) OR lower(keyword) LIKE lower(?)',
             "%#{searchevent}%", "%#{searchevent}%", "%#{searchevent}%"])
    else
      all
    end
  end
end
