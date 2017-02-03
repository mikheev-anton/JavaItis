DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS users_table;

CREATE SEQUENCE users_tab_seq START 1;
CREATE SEQUENCE cars_tab_seq START 1;

CREATE TABLE users_table
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('users_tab_seq'),
  name       VARCHAR NOT NULL,
  age        INTEGER NOT NULL,
  city       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL UNIQUE,
  password   VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_idx ON users_table (name, email);

CREATE TABLE cars(
  id          INTEGER PRIMARY KEY DEFAULT nextval('cars_tab_seq'),
  user_id     INTEGER NOT NULL,
  car_model   VARCHAR NOT NULL,
  car_mileage INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users_table (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX cars_unique_user_number_idx ON cars(user_id, car_model)