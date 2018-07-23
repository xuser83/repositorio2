
SELECT * FROM jauminadb.usuario;
SELECT * FROM jauminadb.productosventa;
select * from detalleventa;
seleCT * FROM jauminadb.venta1;
select * from venta1;
select * from venta1 where id like 184;
select * from detalleventa where id_venta1 like 184;

DELETE FROM `jauminadb`.`detalleventa` where `id`>'0';
DELETE FROM `jauminadb`.`venta1` WHERE `id`>'0';

DELETE FROM `jauminadb`.`productosventa` WHERE `id`<'5';
