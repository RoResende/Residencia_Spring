INSERT INTO Cliente (nome_completo,nome_usuario,cpf,email,endereco,cep,data_nascimento) VALUES ('Rodrigo Resende','Rresende','00000000666','rresende@email.com',
'rua das sombras','00000666','1991-03-05'),
('Rafael Hammes','Hobbit','88888888888','rhammes@email.com',
'rua das sombras','00000666','1991-03-05'),
('Matheus Rodrigues','PowerBI','99999999999','mrodrigues@email.com',
'rua das sombras','00000666','1991-03-05');

INSERT INTO Categoria (tipo,descricao) VALUES ('Drone','Drone, o que você espera?'),
('Sensor','Sensor, duh'),('Microchip','Chip controlador'),('Bateria','Acumulador de energia elétrica');

INSERT INTO Funcionario (nome_completo,cpf) VALUES ('Sicrano','55555555555'),
('Fulanno','66666666666'),('Beltrano','77777777777'),('BigBoss','22222222222');

INSERT INTO Produto (nome_produto,descricao,quantidade,data_fabricacao,preco,categoria_id,funcionario_id) VALUES ('Drone OMG','Drone com painél solar','5','2020-02-05','899',1,2),
('Heater','Sensor térmico','35','2017-04-18','89',2,3),
('SyndicateM','Microchip de controle','20','2019-09-22','259',3,1),
('SuperCharge','Bateria longa duracao','35','2017-04-18','199',4,4);