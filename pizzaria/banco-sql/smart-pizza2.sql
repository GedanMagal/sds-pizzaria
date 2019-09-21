-- MySQL Script generated by MySQL Workbench
-- Fri Sep 20 21:20:42 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pizza_projeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pizza_projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pizza_projeto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pizza_projeto` ;

-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_caixa` (
  `id_caixa` INT(11) NOT NULL AUTO_INCREMENT,
  `cx_descricao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_caixa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_cargo` (
  `id_cargo` INT(2) NOT NULL,
  `ds_descricaoCargo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_cargo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_estado` (
  `id_estado` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_uf` VARCHAR(45) NOT NULL,
  `ds_sigla` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_cidade` (
  `id_cidade` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_cidade` VARCHAR(45) NOT NULL,
  `id_estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  INDEX `fk_tb_cidade_tb_estado1_idx` (`id_estado` ASC) VISIBLE,
  CONSTRAINT `fk_tb_cidade_tb_estado1`
    FOREIGN KEY (`id_estado`)
    REFERENCES `pizza_projeto`.`tb_estado` (`id_estado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_usuario` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_login` VARCHAR(45) NOT NULL,
  `us_senha` VARCHAR(45) NOT NULL,
  `gp_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nm_cliente` VARCHAR(45) NOT NULL,
  `nm_cpf` VARCHAR(11) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `ds_email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `cli_telefone` VARCHAR(45) NOT NULL,
  `cli_celular` VARCHAR(45) NULL,
  `us_id` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk__tb_usuario1_idx` (`us_id` ASC) VISIBLE,
  CONSTRAINT `fk__tb_usuario1`
    FOREIGN KEY (`us_id`)
    REFERENCES `pizza_projeto`.`tb_usuario` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_endereco` (
  `id_endereco` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_logradouro` VARCHAR(255) NOT NULL,
  `nm_endereco` VARCHAR(9) NOT NULL,
  `nm_cep` VARCHAR(11) NOT NULL,
  `ds_bairro` VARCHAR(45) NOT NULL,
  `id_cidade` INT(11) NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_endereco`),
  INDEX `fk_tb_endereco_tb_cidade1_idx` (`id_cidade` ASC) VISIBLE,
  INDEX `fk_tb_endereco_1_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_tb_endereco_tb_cidade1`
    FOREIGN KEY (`id_cidade`)
    REFERENCES `pizza_projeto`.`tb_cidade` (`id_cidade`),
  CONSTRAINT `fk_tb_endereco_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `pizza_projeto`.`tb_cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_item_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_item_pedido` (
  `id_item_pedido` INT(11) NOT NULL AUTO_INCREMENT,
  `quantidade` INT(2) NOT NULL,
  `desconto` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  PRIMARY KEY (`id_item_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_forma_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_forma_pagamento` (
  `id_forma_pagamento` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_tipo_pagamento` VARCHAR(45) NOT NULL,
  `ds_bandeira` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_forma_pagamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_historico_caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_historico_caixa` (
  `id_historico_caixa` INT(11) NOT NULL AUTO_INCREMENT,
  `dt_abertura` DATE NOT NULL,
  `dt_fechamento` DATE NOT NULL,
  `vl_abertura` DOUBLE NOT NULL,
  `vl_fechamento` DOUBLE NULL DEFAULT NULL,
  `id_caixa` INT(11) NOT NULL,
  PRIMARY KEY (`id_historico_caixa`),
  INDEX `fk_tb_historico_caixa_tb_caixa1_idx` (`id_caixa` ASC) VISIBLE,
  CONSTRAINT `fk_tb_historico_caixa_tb_caixa1`
    FOREIGN KEY (`id_caixa`)
    REFERENCES `pizza_projeto`.`tb_caixa` (`id_caixa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_pagamento` (
  `id_pagamento` INT(11) NOT NULL AUTO_INCREMENT,
  `dt_horaPaggamento` DATETIME(2) NOT NULL,
  `id_forma_pagamento` INT(11) NOT NULL,
  `id_historico_caixa` INT(11) NOT NULL,
  PRIMARY KEY (`id_pagamento`),
  INDEX `fk_tb_pagamento_tb_forma_pagamento1_idx` (`id_forma_pagamento` ASC) VISIBLE,
  INDEX `fk_tb_pagamento_tb_historico_caixa1_idx` (`id_historico_caixa` ASC) VISIBLE,
  CONSTRAINT `fk_tb_pagamento_tb_forma_pagamento1`
    FOREIGN KEY (`id_forma_pagamento`)
    REFERENCES `pizza_projeto`.`tb_forma_pagamento` (`id_forma_pagamento`),
  CONSTRAINT `fk_tb_pagamento_tb_historico_caixa1`
    FOREIGN KEY (`id_historico_caixa`)
    REFERENCES `pizza_projeto`.`tb_historico_caixa` (`id_historico_caixa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_funcionario` (
  `id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `nm_funcionario` VARCHAR(45) NOT NULL,
  `nm_cpf` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `dataAdmissao` DATE NOT NULL,
  `id_cargo` INT(2) NOT NULL,
  `us_id` INT(11) NOT NULL,
  INDEX `fk_tb_pizza_funcionario_tb_cargo1_idx` (`id_cargo` ASC) VISIBLE,
  PRIMARY KEY (`id_funcionario`),
  INDEX `fk_tb_funcionario_tb_usuario1_idx` (`us_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_pizza_funcionario_tb_cargo1`
    FOREIGN KEY (`id_cargo`)
    REFERENCES `pizza_projeto`.`tb_cargo` (`id_cargo`),
  CONSTRAINT `fk_tb_funcionario_tb_usuario1`
    FOREIGN KEY (`us_id`)
    REFERENCES `pizza_projeto`.`tb_usuario` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_pedido` (
  `id_pedido` INT(11) NOT NULL AUTO_INCREMENT,
  `data_pedido` DATE NOT NULL,
  `vl_vlaor_pedido` VARCHAR(45) NOT NULL,
  `vl_troco` VARCHAR(45) NOT NULL,
  `id_pagamento` INT(11) NOT NULL,
  `id_item_pedido` INT(11) NOT NULL,
  `id_cliente` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_tb_pedido_tb_pagamento1_idx` (`id_pagamento` ASC) VISIBLE,
  INDEX `fk_tb_pedido_tb_item_pedido1_idx` (`id_item_pedido` ASC) VISIBLE,
  INDEX `fk_tb_pedido_tb_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_tb_pedido_tb_funcionario1_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_tb_pedido_tb_item_pedido1`
    FOREIGN KEY (`id_item_pedido`)
    REFERENCES `pizza_projeto`.`tb_item_pedido` (`id_item_pedido`),
  CONSTRAINT `fk_tb_pedido_tb_pagamento1`
    FOREIGN KEY (`id_pagamento`)
    REFERENCES `pizza_projeto`.`tb_pagamento` (`id_pagamento`),
  CONSTRAINT `fk_tb_pedido_tb_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `pizza_projeto`.`tb_cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_pedido_tb_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `pizza_projeto`.`tb_funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_entrega` (
  `id_entrega` INT(11) NOT NULL AUTO_INCREMENT,
  `dataHorario` DATE NOT NULL,
  `vl_entrega` VARCHAR(45) NOT NULL,
  `id_pedido` INT(11) NOT NULL,
  `iid_endereco` INT(11) NOT NULL,
  PRIMARY KEY (`id_entrega`),
  INDEX `fk_tb_entrega_tb_pedido1_idx` (`id_pedido` ASC) VISIBLE,
  INDEX `fk_tb_entrega_tb_endereco1_idx` (`iid_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_tb_entrega_tb_pedido1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `pizza_projeto`.`tb_pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_entrega_tb_endereco1`
    FOREIGN KEY (`iid_endereco`)
    REFERENCES `pizza_projeto`.`tb_endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_estoque` (
  `id_estoque` INT(11) NOT NULL,
  `qtd_estoque` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_estoque`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_ingrediente` (
  `id_ingredientes` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_ingredientes` VARCHAR(255) NOT NULL,
  `requerido` TINYINT(4) NOT NULL,
  `valor_ingrediente` DOUBLE NOT NULL,
  PRIMARY KEY (`id_ingredientes`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_tipo_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_tipo_produto` (
  `id_tipo_produto` INT(11) NOT NULL,
  `tb_tipo_produtocol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_produto` (
  `id_produto` INT(11) NOT NULL,
  `nm_produto` VARCHAR(45) NOT NULL,
  `ds_tamanho` VARCHAR(45) NOT NULL,
  `valor_produto` FLOAT NOT NULL,
  `id_estoque` INT(11) NOT NULL,
  `id_tipo_produto` INT(11) NOT NULL,
  PRIMARY KEY (`id_produto`),
  INDEX `fk_tb_produto_tb_estoque1_idx` (`id_estoque` ASC) VISIBLE,
  INDEX `fk_tb_produto_tb_tipo_produto1_idx` (`id_tipo_produto` ASC) VISIBLE,
  CONSTRAINT `fk_tb_produto_tb_estoque1`
    FOREIGN KEY (`id_estoque`)
    REFERENCES `pizza_projeto`.`tb_estoque` (`id_estoque`),
  CONSTRAINT `fk_tb_produto_tb_tipo_produto1`
    FOREIGN KEY (`id_tipo_produto`)
    REFERENCES `pizza_projeto`.`tb_tipo_produto` (`id_tipo_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_sabor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_sabor` (
  `id_sabor` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_sabor` VARCHAR(255) NOT NULL,
  `id_produto` INT(11) NOT NULL,
  PRIMARY KEY (`id_sabor`),
  INDEX `fk_tb_sabor_tb_produto1_idx` (`id_produto` ASC) VISIBLE,
  CONSTRAINT `fk_tb_sabor_tb_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `pizza_projeto`.`tb_produto` (`id_produto`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_ingrediente_sabor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_ingrediente_sabor` (
  `tb_pizza_ingrediente_id_ingredientes` INT(11) NOT NULL,
  `tb_sabor_id_sabor` INT(11) NOT NULL,
  PRIMARY KEY (`tb_pizza_ingrediente_id_ingredientes`, `tb_sabor_id_sabor`),
  INDEX `fk_tb_pizza_ingrediente_has_tb_sabor_tb_sabor1_idx` (`tb_sabor_id_sabor` ASC) VISIBLE,
  INDEX `fk_tb_pizza_ingrediente_has_tb_sabor_tb_pizza_ingrediente1_idx` (`tb_pizza_ingrediente_id_ingredientes` ASC) VISIBLE,
  CONSTRAINT `fk_tb_pizza_ingrediente_has_tb_sabor_tb_pizza_ingrediente1`
    FOREIGN KEY (`tb_pizza_ingrediente_id_ingredientes`)
    REFERENCES `pizza_projeto`.`tb_ingrediente` (`id_ingredientes`),
  CONSTRAINT `fk_tb_pizza_ingrediente_has_tb_sabor_tb_sabor1`
    FOREIGN KEY (`tb_sabor_id_sabor`)
    REFERENCES `pizza_projeto`.`tb_sabor` (`id_sabor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_item_pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_item_pedido_produto` (
  `tb_item_pedido_id_item_pedido` INT(11) NOT NULL,
  `tb_produto_id_produto` INT(11) NOT NULL,
  PRIMARY KEY (`tb_item_pedido_id_item_pedido`, `tb_produto_id_produto`),
  INDEX `fk_tb_item_pedido_has_tb_produto_tb_produto1_idx` (`tb_produto_id_produto` ASC) VISIBLE,
  INDEX `fk_tb_item_pedido_has_tb_produto_tb_item_pedido1_idx` (`tb_item_pedido_id_item_pedido` ASC) VISIBLE,
  CONSTRAINT `fk_tb_item_pedido_has_tb_produto_tb_item_pedido1`
    FOREIGN KEY (`tb_item_pedido_id_item_pedido`)
    REFERENCES `pizza_projeto`.`tb_item_pedido` (`id_item_pedido`),
  CONSTRAINT `fk_tb_item_pedido_has_tb_produto_tb_produto1`
    FOREIGN KEY (`tb_produto_id_produto`)
    REFERENCES `pizza_projeto`.`tb_produto` (`id_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pizza_projeto`.`tb_movimento_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza_projeto`.`tb_movimento_estoque` (
  `id_movimento_estoque` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `dt_movimentacao` DATE NOT NULL,
  `quantidade` INT(2) NOT NULL,
  `id_estoque` INT(11) NOT NULL,
  PRIMARY KEY (`id_movimento_estoque`),
  INDEX `fk_tb_movimento_estoque_tb_estoque1_idx` (`id_estoque` ASC) VISIBLE,
  CONSTRAINT `fk_tb_movimento_estoque_tb_estoque1`
    FOREIGN KEY (`id_estoque`)
    REFERENCES `pizza_projeto`.`tb_estoque` (`id_estoque`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
