-- INSERT INTO system_users (id, username, password, first_name, lastname, role) VALUES
--      (1, 'aleksandar', 'janev', 'aleksandar', 'janev', 'ROLE_ADMIN');

INSERT INTO country (name, continent) VALUES
     ('Aegean Macedonia', 'Europe'),
     ('Macedonia', 'Europe'),
     ('California', 'America'),
     ('Canberra', 'Australia');

INSERT INTO host (name, surname, country_id) VALUES
     ('Manoli', 'Manolevski', 1),
     ('Aleksandar', 'Janev', 2),
     ('John', 'Doe', 3),
     ('Billy', 'Jones', 4);

INSERT INTO accommodation (name, category, host_id, num_rooms, is_reserved) VALUES
    ('Manoli''s', 'HOTEL', 1, 3, false ),
    ( 'Fishy', 'APARTMENT', 2, 3, false ),
    ( 'Moni''s', 'FLAT', 3, 1, false ),
    ( 'Tagora''s', 'MOTEL', 4, 1, false );

INSERT INTO reservation (code, start_date, end_date, num_of_guests, price, accommodation_id,confirmed) VALUES
    ( '1213', CURRENT_DATE, CURRENT_DATE, 2, 500, 1,false),
    ('1214', CURRENT_DATE, CURRENT_DATE, 2, 500, 2,false);


-- INSERT INTO temporary_reservation (id, code,
--                                    start_date,
--                                    end_date,
--                                    num_of_guests,
--                                    price,
--                                    accommodation_id,
--                                    user_id, confirmed) VALUES
--     (1, '1213', CURRENT_DATE, CURRENT_DATE, 2, 500, 1, 1,false),
--     (2, '1214', CURRENT_DATE, CURRENT_DATE, 2, 500, 2, 2,false);
