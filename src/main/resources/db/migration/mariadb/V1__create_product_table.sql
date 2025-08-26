CREATE TABLE IF NOT EXISTS product
(
    id            VARCHAR(36)   NOT NULL,
    name          VARCHAR(255) NULL,
    image_url     VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price         DECIMAL      NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);g