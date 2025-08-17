
/*PRODUCTOS*/
INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Frapellate', 4.50, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Frapellate') LIMIT 1;

INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Mocalate', 3.80, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Mocalate') LIMIT 1;

INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Milkshake de Oreo', 5.00, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Milkshake de Oreo') LIMIT 1;

INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Café Latte', 3.50, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Café Latte') LIMIT 1;

INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Cappuccino', 3.20, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Cappuccino') LIMIT 1;

INSERT INTO producto (nombre, precio, disponible)
SELECT * FROM (SELECT 'Espresso', 2.50, true) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM producto WHERE nombre = 'Espresso') LIMIT 1;

/*CLIENTES INFO*/
INSERT INTO cliente (nombre, correo, telefono)
VALUES ('Freya Lopez', 'freya@example.com', '0991234567')
ON DUPLICATE KEY UPDATE correo = VALUES(correo), telefono = VALUES(telefono);

INSERT INTO cliente (nombre, correo, telefono)
VALUES ('Milena Lopez', 'milena@example.com', '0987654321')
ON DUPLICATE KEY UPDATE correo = VALUES(correo), telefono = VALUES(telefono);

INSERT INTO cliente (nombre, correo, telefono)
VALUES ('Isabel Lopez', 'isabel@example.com', '0999876543')
ON DUPLICATE KEY UPDATE correo = VALUES(correo), telefono = VALUES(telefono);

INSERT INTO cliente (nombre, correo, telefono)
VALUES ('Lopez Fiorella', 'fiorella@example.com', '0987654321')
ON DUPLICATE KEY UPDATE correo = VALUES(correo), telefono = VALUES(telefono);

INSERT INTO cliente (nombre, correo, telefono)
VALUES ('Lopez Fernando', 'fernando@example.com', '0999876543')
ON DUPLICATE KEY UPDATE correo = VALUES(correo), telefono = VALUES(telefono);

/*ORDENES*/
INSERT INTO orden (cliente_id, fecha, total)
SELECT * FROM (SELECT 1, NOW(), 8.00) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden WHERE cliente_id = 1 AND total = 8.00 LIMIT 1);

INSERT INTO orden (cliente_id, fecha, total)
SELECT * FROM (SELECT 2, NOW(), 9.50) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden WHERE cliente_id = 2 AND total = 9.50 LIMIT 1);

INSERT INTO orden (cliente_id, fecha, total)
SELECT * FROM (SELECT 3, NOW(), 5.50) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden WHERE cliente_id = 3 AND total = 5.50 LIMIT 1);

/*ORDENES-PRODUCTOS*/
INSERT INTO orden_producto (orden_id, producto_id)
SELECT * FROM (SELECT 1, 2) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden_producto WHERE orden_id = 1 AND producto_id = 2 LIMIT 1);

INSERT INTO orden_producto (orden_id, producto_id)
SELECT * FROM (SELECT 2, 3) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden_producto WHERE orden_id = 2 AND producto_id = 3 LIMIT 1);

INSERT INTO orden_producto (orden_id, producto_id)
SELECT * FROM (SELECT 2, 4) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden_producto WHERE orden_id = 2 AND producto_id = 4 LIMIT 1);

INSERT INTO orden_producto (orden_id, producto_id)
SELECT * FROM (SELECT 3, 5) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden_producto WHERE orden_id = 3 AND producto_id = 5 LIMIT 1);

INSERT INTO orden_producto (orden_id, producto_id)
SELECT * FROM (SELECT 3, 6) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM orden_producto WHERE orden_id = 3 AND producto_id = 6 LIMIT 1);
