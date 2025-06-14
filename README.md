create table TourDiscount (
  id INT IDENTITY(1,1) PRIMARY KEY,
  tour_id INT NOT NULL,
  discount_id INT NOT NULL,
  FOREIGN KEY (tour_id) REFERENCES [Tour](id),
  FOREIGN KEY (discount_id) REFERENCES [Discount](id)
)

ALTER TABLE [Review]
  ADD status varchar(20);
