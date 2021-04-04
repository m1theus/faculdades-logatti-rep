CREATE TABLE IF NOT EXISTS `chatdb`.TB_ORDERS
(
    id            BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description   VARCHAR(255) NOT NULL,
    purchase_date DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `chatdb`.TB_PRODUCTS
(
    id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    type        varchar(50)  NOT NULL
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `chatdb`.TB_ORDER_ITEMS
(
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL
) ENGINE = INNODB;


INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (1, 'Forno Eletrico Britania Bfe36p 36l Preto - 127v', 'Cozinha');
INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (2, 'Pipoqueira Pop Time Pip B-02 Britania 220V', 'Cozinha');
INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (3, 'Liquidificador Diamante 800pr 127v', 'Cozinha');
INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (4, 'New Nintendo Switch Azul e Vermelho Neon', 'Games');
INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (5, 'Console Xbox One S 1tb com 1 controle', 'Games');
INSERT INTO `chatdb`.TB_PRODUCTS(id, description, type)
VALUES (6, 'Game - DMC Devil May Cry: Definitive Edition - PS4', 'Games');

INSERT INTO `chatdb`.TB_ORDERS(id, description)
VALUES (1, 'compra de natal');
INSERT INTO `chatdb`.TB_ORDERS(id, description)
VALUES (2, 'compra de aniversario');

INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (1, 3);
INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (1, 6);
INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (1, 2);
INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (2, 5);
INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (2, 1);
INSERT INTO `chatdb`.TB_ORDER_ITEMS(order_id, product_id)
VALUES (2, 5);


use chatdb;

select TB_O.id            as ORDER_ID,
       TB_P.id            as PRODUCT_ID,
       TB_O.description   as ORDER_DESCRIPTION,
       TB_P.description   as PRODUCT_DESCRIPTION,
       TB_P.type          as PRODUCT_TYPE,
       TB_O.purchase_date as PURCHASE_DATE
from TB_ORDER_ITEMS TOI
         inner join TB_ORDERS TB_O on TOI.order_id = TB_O.id
         inner join TB_PRODUCTS TB_P on TOI.product_id = TB_P.id
ORDER BY TB_O.id;