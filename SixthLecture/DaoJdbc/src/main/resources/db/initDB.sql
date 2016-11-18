CREATE TABLE users
(
  id         SERIAL PRIMARY KEY,
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE cars(
  id          SERIAL PRIMARY KEY,
  user_id     INTEGER NOT NULL,
  car_type    VARCHAR NOT NULL,
  car_model    VARCHAR NOT NULL,
  car_number  VARCHAR NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX cars_unique_user_number_idx ON cars(user_id, car_number)