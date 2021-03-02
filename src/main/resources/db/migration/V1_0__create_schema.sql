CREATE SCHEMA IF NOT EXISTS seeds;

CREATE TABLE IF NOT EXISTS seeds.ingredient
(
    id                    BIGSERIAL     PRIMARY KEY NOT NULL,
    name                  TEXT                      NOT NULL,
    created_datetime      TIMESTAMP,
    last_updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS seeds.food_group
(
    id                    BIGSERIAL     PRIMARY KEY NOT NULL,
    name                  TEXT                      NOT NULL,
    created_datetime      TIMESTAMP,
    last_updated_datetime TIMESTAMP
);

CREATE TABLE IF NOT EXISTS seeds.ingredient_food_group
(
    ingredient_id      BIGINT  NOT NULL,
    food_group_id      BIGINT  NOT NULL,
    CONSTRAINT ingredient_food_group_pkey PRIMARY KEY (ingredient_id, food_group_id),
    CONSTRAINT fk_ingredient_ingredient_food_group FOREIGN KEY(ingredient_id) REFERENCES seeds.ingredient(id) ON UPDATE CASCADE,
    CONSTRAINT fk_food_group_ingredient_food_group FOREIGN KEY(food_group_id) REFERENCES seeds.food_group(id) ON UPDATE CASCADE
);