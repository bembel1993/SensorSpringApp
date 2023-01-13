CREATE TABLE `sensor` (
                          `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                          `name` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `model` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `type` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `range` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `unit` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `location` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          `description` VARCHAR(150) NOT NULL DEFAULT '0' COLLATE 'cp1250_general_ci',
                          PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='cp1250_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

INSERT INTO sensor VALUE (1, 'Sensor 1', 'PC33-56','Pressure','0-16','bar','Room1','new equip');
