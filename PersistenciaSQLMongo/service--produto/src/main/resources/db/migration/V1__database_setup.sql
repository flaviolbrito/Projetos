CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT,
    codigo VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    quantidade INT DEFAULT 0,
    valor DOUBLE NOT NULL,
    UNIQUE(codigo),
    PRIMARY KEY (id)
);

INSERT INTO produto (codigo, nome, quantidade, valor) VALUES (
    "36c7e4b0-b178-4627-8d7b-23f5ceba598f",
    "Livro Clean Code",
    50,
    79.99
);

INSERT INTO produto (codigo, nome, quantidade, valor) VALUES (
    "b01941c8-a465-40b3-95f7-6588ff53b1aa",
    "Macbook Pro M1",
    20,
    12599.99
);

INSERT INTO produto (codigo, nome, quantidade, valor) VALUES (
    "37ba3ca8-9e1c-412d-9acb-00f6eef26e0b",
    "GoPro",
    5,
    2399.99
);