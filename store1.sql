CREATE DATABASE store;
USE store;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE categories (id INT AUTO_INCREMENT, category_name VARCHAR(50), PRIMARY KEY (id)) ENGINE=MYISAM CHARACTER SET=UTF8; 
CREATE TABLE groups (id INT AUTO_INCREMENT, groups_name VARCHAR(20), PRIMARY KEY(id)) ENGINE=MyISAM CHARACTER SET=utf8;

CREATE TABLE persons (id INT AUTO_INCREMENT, first_name VARCHAR(100), last_Name VARCHAR(50), email VARCHAR(50), 
                     password VARCHAR(50), address VARCHAR(200), phone VARCHAR(15), groups_id INT, PRIMARY KEY(id)) 
                     ENGINE=MyISAM CHARACTER SET=utf8; 
                     
CREATE TABLE products (id INT AUTO_INCREMENT,  product_name VARCHAR(50), description VARCHAR(1000), category_id INT,
					 price DOUBLE, residue INT, PRIMARY KEY(id))ENGINE=MyISAM CHARACTER SET=utf8;  
                        
CREATE TABLE orderstatu (id INT AUTO_INCREMENT, status VARCHAR(9), PRIMARY KEY(id)) ENGINE=MyISAM CHARACTER SET=utf8; 
 
CREATE TABLE customer_orders (id INT AUTO_INCREMENT, person_id INT, date_created DATE, 
						date_closing DATE, orderstatus_id INT, PRIMARY KEY(id)) ENGINE=MyISAM CHARACTER SET=utf8; 
                            
                            
CREATE TABLE orderitems (id INT AUTO_INCREMENT, customer_order_id INT,  product_id INT, 
						quantity INT, PRIMARY KEY(id)) ENGINE=MyISAM CHARACTER SET=utf8;  
                        
INSERT INTO groups (id, groups_name) VALUES (1, 'USER');  
INSERT INTO groups (id, groups_name) VALUES (2, 'ADMIN');                        
                        
INSERT INTO persons (first_name, last_Name, email, password, address, phone, groups_id) 
                  VALUES ('Admin', '', 'bdv@bk.ru','bdv', 'г.Минск, ул.Голодеда 75-6', '+375296849031', 2);   
                  
INSERT INTO persons (first_name, last_Name, email, password, address, phone, groups_id) 
                  VALUES ('Елена', 'Хмель', 'hemel@bk.ru','1', 'г.Минск, пр.Рокоссовского 4-4-434', '+375293372580', 1);
                  
INSERT INTO persons (first_name, last_Name, email, password, address, phone, groups_id) 
                  VALUES ('Ярослав', 'Миронов', 'mironov@bk.ru','2', 'г.Минск, ул.Мирошниченко 10-148', '+375297589843', 1);                 
                        
 