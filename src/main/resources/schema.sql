> CREATE TABLE IF NOT EXISTS `leiacomigo`.`usuario` (
>   `idUsuario` BIGINT NOT NULL AUTO_INCREMENT,
>   `email` VARCHAR(200) NULL,
>   `nomeCompleto` VARCHAR(200) NULL,
>   `nomeUsuario` VARCHAR(50) NOT NULL,
>   `senha` VARCHAR(50) NULL,
>   `dataDeNascimento` DATETIME NULL,
> )
> ENGINE = InnoDB;