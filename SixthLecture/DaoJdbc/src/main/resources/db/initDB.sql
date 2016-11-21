CREATE TABLE users_table
(
  id         SERIAL PRIMARY KEY,
  name       VARCHAR NOT NULL,
  age        INTEGER NOT NULL,
  city       VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_idx ON users_table (name, city);

CREATE TABLE cars(
  id          SERIAL PRIMARY KEY,
  user_id     INTEGER NOT NULL,
  car_model   VARCHAR NOT NULL,
  car_mileage INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX cars_unique_user_number_idx ON cars(user_id, car_model)