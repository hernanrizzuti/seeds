CREATE SCHEMA IF NOT EXISTS seeds;

CREATE TABLE IF NOT EXISTS seeds.ingredient
(
    id                    BIGSERIAL     PRIMARY KEY NOT NULL,
    name                  TEXT                      NOT NULL,
    created_datetime      TIMESTAMP,
    last_updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS seeds.ingredient_group
(
    id                    BIGSERIAL     PRIMARY KEY NOT NULL,
    name                  TEXT                      NOT NULL,
    created_datetime      TIMESTAMP,
    last_updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS seeds.ingredient_ingredient_group
(
    ingredient_id            BIGINT  NOT NULL,
    ingredient_group_id      BIGINT  NOT NULL,
    CONSTRAINT ingredient_ingredient_group_pkey PRIMARY KEY (ingredient_id, ingredient_group_id)
);

GRANT ALL ON SCHEMA seeds to svc_seeds;
GRANT ALL ON ALL TABLES IN SCHEMA seeds to svc_seeds;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA seeds TO svc_seeds;