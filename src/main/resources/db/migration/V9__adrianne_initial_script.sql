DROP SCHEMA IF EXISTS adrianne cascade;
CREATE SCHEMA adrianne;

CREATE TABLE adrianne.users (
     user_id uuid,
     first_name varchar(150),
     last_name varchar(150),
     password varchar(150),
     email varchar(150),
     mobile_number bigserial,
     total_orders int,
     success_orders int,
     created_date TIMESTAMP WITH TIME ZONE,
     modified_date TIMESTAMP WITH TIME ZONE,
     PRIMARY KEY (user_id)
)