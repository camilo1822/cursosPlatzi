SELECT * FROM AmazonViewer.viewed WHERE id_material= 1 AND id_element= 6 AND id_user= 1;
ALTER TABLE AmazonViewer.viewed ADD viewed_date DATETIME;

INSERT INTO AmazonViewer.viewed (id_material,id_element,id_user,viewed_date) VALUES(1,10,1,'2019-07-27 09:11:57.57');
DELETE FROM AmazonViewer.viewed WHERE id = 3;

SELECT * FROM AmazonViewer.viewed WHERE id_material= 1 AND id_element= 10 AND id_user= 1 AND viewed_date='2019-07-27 00:00:00.0';