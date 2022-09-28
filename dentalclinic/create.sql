CREATE TABLE IF NOT EXISTS tb_tipo_usuario(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS tb_endereco(
id INT AUTO_INCREMENT PRIMARY KEY,
logradouro VARCHAR(255),
numero VARCHAR(64),
complemento VARCHAR(64),
bairro VARCHAR(255),
localidade VARCHAR(255),
uf CHAR(2),
cep CHAR(8)
);

CREATE TABLE IF NOT EXISTS tb_clinica(
id INT AUTO_INCREMENT PRIMARY KEY,
nomeFantasia VARCHAR(32),
razaoSocial VARCHAR(64),
fk_idEndereco INT,
);

ALTER TABLE tb_clinica ADD FOREIGN KEY (fk_idEndereco) REFERENCES tb_endereco(id);

CREATE TABLE IF NOT EXISTS tb_usuario(
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(64),
senha VARCHAR(64),
fk_idTipoUsuario INT
);

ALTER TABLE tb_usuario ADD FOREIGN KEY (fk_idTipoUsuario) REFERENCES tb_tipo_usuario(id);

CREATE TABLE IF NOT EXISTS tb_dentista(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(64),
cro VARCHAR(32)
fk_idUsuario INT,
);

ALTER TABLE tb_dentista ADD FOREIGN KEY (fk_idUsuario) REFERENCES tb_usuario(id);

CREATE TABLE IF NOT EXISTS tb_paciente(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(64),
sobrenome VARCHAR(64),
cpf CHAR(11),
telefone VARCHAR(32)
fk_idUsuario INT
fk_idEndereco INT
);

ALTER TABLE tb_paciente ADD FOREIGN KEY (fk_idUsuario) REFERENCES tb_usuario(id);
ALTER TABLE tb_paciente ADD FOREIGN KEY (fk_idEndereco) REFERENCES tb_endereco(id);

CREATE TABLE IF NOT EXISTS tb_consulta(
id INT AUTO_INCREMENT PRIMARY KEY,
dataConsulta DATE,
descricao VARCHAR(64),
status VARCHAR(32),
fk_idPaciente INT,
fk_idDentista INT
);

ALTER TABLE tb_clinica ADD FOREIGN KEY (fk_idPaciente) REFERENCES tb_paciente(id);
ALTER TABLE tb_consulta ADD FOREIGN KEY (fk_idDentista) REFERENCES tb_dentista(id);