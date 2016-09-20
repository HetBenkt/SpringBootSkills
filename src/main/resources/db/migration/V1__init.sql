CREATE TABLE product (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE product_list (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product_list_products (
    lists_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL,
    UNIQUE KEY (lists_id, products_id)
);

CREATE TABLE person (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    keywords VARCHAR(255),
    PRIMARY KEY (id)
);
