DELETE FROM cars;
DELETE FROM users_table;

ALTER SEQUENCE cars_id_seq RESTART WITH 1;
ALTER SEQUENCE users_table_id_seq RESTART WITH 1;

-- admin
INSERT INTO users_table (name, age, city, email, password) VALUES
  ('Ilya',33,'МСК', 'Ilya@ya.ru','f6a539b519ee29bf01d8562773bf5c32'),
  ('Poma',31,'ЕКБ','Poma@ya.ru','f6a539b519ee29bf01d8562773bf5c32'),
  ('Vladimir',39,'ЕКБ','Vl@ya.ru','f6a539b519ee29bf01d8562773bf5c32'),
  ('Toleg',27,'УФА','Toleg@ya.ru','f6a539b519ee29bf01d8562773bf5c32'),
  ('Leha',25,'Ижевск','Leha@ya.ru','f6a539b519ee29bf01d8562773bf5c32');


INSERT INTO cars (car_model, car_mileage, user_id) VALUES
  ('Mercedes', 20000, 2),
  ('Audi', 154265, 4),
  ('Skoda', 12452, 5),
  ('Renault', 424578, 3),
  ('Девятоз', 999999, 5),
  ('Isuzu', 254867, 5),
  ('Renault', 120000, 1),
  ('Toyota', 521364, 4);