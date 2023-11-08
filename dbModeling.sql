DROP DATABASE IF EXISTS imobiliaria;

CREATE DATABASE imobiliaria;

USE imobiliaria;

-- Tabela para armazenar informações sobre as regiões
CREATE TABLE regioes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

-- Tabela para armazenar informações sobre os endereços
CREATE TABLE enderecos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    regiao_id INT,
    FOREIGN KEY (regiao_id) REFERENCES regioes(id)
);

-- Tabela para armazenar informações sobre os clientes
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    endereco_id INT,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (endereco_id) REFERENCES enderecos(id)
);

-- Tabelas filhas de clientes
CREATE TABLE locador (
    cliente_id INT PRIMARY KEY,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE locatario (
    cliente_id INT PRIMARY KEY,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE vendedor (
    cliente_id INT PRIMARY KEY,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE comprador (
    cliente_id INT PRIMARY KEY,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabela para armazenar informações sobre os corretores
CREATE TABLE corretores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    endereco_id INT,
    data_contratacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    regiao_id INT,
    salario DECIMAL(10, 2) NOT NULL,
    comissao DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (regiao_id) REFERENCES regioes(id),
    FOREIGN KEY (endereco_id) REFERENCES enderecos(id)
);

-- Tabela para armazenar informações sobre as propriedades
CREATE TABLE propriedades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    endereco_id INT,
    preco DECIMAL(10, 2) NOT NULL,
    tipo ENUM('Casa', 'Apartamento', 'Terreno', 'Comercial') NOT NULL,
    descricao TEXT,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    proprietario_id INT,
    regiao_id INT,
    vendedor_id INT,
    FOREIGN KEY (proprietario_id) REFERENCES vendedor(cliente_id),
    FOREIGN KEY (regiao_id) REFERENCES regioes(id),
    FOREIGN KEY (endereco_id) REFERENCES enderecos(id),
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(cliente_id)
);

-- Tabela para armazenar informações sobre as vendas
CREATE TABLE vendas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    propriedade_id INT,
    corretor_id INT,
    cliente_id INT,
    data_venda DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    preco_venda DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (propriedade_id) REFERENCES propriedades(id),
    FOREIGN KEY (corretor_id) REFERENCES corretores(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabela para gerir os imóveis alugados
CREATE TABLE alugueis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    propriedade_id INT,
    locador_id INT,
    locatario_id INT,
    data_inicio DATETIME NOT NULL,
    data_fim DATETIME,
    valor_mensal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (propriedade_id) REFERENCES propriedades(id),
    FOREIGN KEY (locador_id) REFERENCES locador(cliente_id),
    FOREIGN KEY (locatario_id) REFERENCES locatario(cliente_id)
);