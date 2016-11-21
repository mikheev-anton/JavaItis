DELETE FROM cars;
DELETE FROM users_table;

ALTER SEQUENCE cars_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

-- admin
INSERT INTO users_table (name, age, city) VALUES
  ('Ilya',33,'МСК'),
  ('Poma',31,'ЕКБ'),
  ('Vladimir',39,'ЕКБ'),
  ('Toleg',27,'УФА'),
  ('Leha',25,'Ижевск');


INSERT INTO cars (car_model, car_mileage, user_id) VALUES
  ('Mercedes', 20000, 2),
  ('Audi', 154265, 4),
  ('Skoda', 12452, 5),
  ('Renault', 424578, 3),
  ('Девятоз', 999999, 5),
  ('Isuzu', 254867, 5),
  ('Renault', 120000, 1),
  ('Toyota', 521364, 4);