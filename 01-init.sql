CREATE TYPE role AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

CREATE TYPE category AS ENUM ('ROOM', 'HOUSE', 'FLAT', 'APARTMENT', 'HOTEL', 'MOTEL');


CREATE TABLE system_users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    lastname VARCHAR(255),
    password VARCHAR(255),
    role role NOT NULL,
    username VARCHAR(255)
);


CREATE TABLE country (
    id BIGSERIAL PRIMARY KEY,
    continent VARCHAR(255),
    name VARCHAR(255)
);


CREATE TABLE host (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    country_id BIGSERIAL,

    CONSTRAINT fk_host_country FOREIGN KEY (country_id) REFERENCES country (id) ON DELETE CASCADE
);


CREATE TABLE accommodation (
    id BIGSERIAL PRIMARY KEY,
    category VARCHAR(255),
    name VARCHAR(255),
    num_rooms INTEGER,
    host_id BIGSERIAL,
    is_reserved BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_accommodation_host FOREIGN KEY (host_id) REFERENCES host (id) ON DELETE CASCADE
);


CREATE TABLE reservation (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(255),
    end_date DATE,
    num_of_guests INTEGER,
    price INTEGER,
    start_date DATE,
    accommodation_id BIGSERIAL,
    confirmed BOOLEAN DEFAULT FALSE,


    CONSTRAINT fk_reservation_accommodation FOREIGN KEY (accommodation_id) REFERENCES accommodation (id) ON DELETE CASCADE
);


CREATE TABLE temporary_reservation (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(255),
    end_date DATE,
    num_of_guests INTEGER,
    price INTEGER,
    start_date DATE,
    accommodation_id BIGSERIAL,
    user_id BIGSERIAL,
    confirmed BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_temp_reservation_accommodation FOREIGN KEY (accommodation_id) REFERENCES accommodation (id) ON DELETE CASCADE,
    CONSTRAINT fk_temp_reservation_user FOREIGN KEY (user_id) REFERENCES system_users (id) ON DELETE CASCADE
);
