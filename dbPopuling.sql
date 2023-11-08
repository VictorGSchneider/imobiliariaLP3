USE imobiliaria;

-- Populating regioes table
INSERT INTO regioes (nome) VALUES ('Norte'), ('Sul'), ('Leste'), ('Oeste');

-- Populating enderecos table
INSERT INTO enderecos (rua, numero, bairro, cidade, estado, cep, pais, regiao_id) VALUES ('Rua Alaor Farias', 123, 'Centro', 'Ijui', 'RS', '12345-000', 'Brasil', 1), ('Rua Baranguete', 456, 'Soslaio', 'Panambi', 'RS', '12345-000', 'Brasil', 2);

-- Populating clientes table
INSERT INTO clientes (nome, cpf, telefone, email, endereco_id) VALUES ('João Silva', '123.456.789-00', '(11) 98765-4321', 'joao@email.com', 1), ('Maria Oliveira', '987.654.321-00', '(11) 91234-5678', 'maria@email.com', 2);

-- Populating propriedades table
INSERT INTO propriedades (nome, descricao, preco, tipo, data_cadastro, endereco_id) VALUES ('Casa Luxo', 'Casa com piscina e churrasqueira', 1000000.00, 'Casa', NOW(), 1);

-- Populating corretores table
INSERT INTO corretores (nome, telefone, email, data_contratacao, salario, comissao, regiao_id) VALUES ('Carlos', '(11) 92345-6789', 'carlos@email.com', NOW(), 3000.00, 0.05, regiao_id);

-- Populating alugueis table
INSERT INTO alugueis (propriedade_id, locador_id, locatario_id, data_inicio, data_fim, valor_mensal) VALUES (propriedade_id, locador_id, locatario_id, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 5000.00);