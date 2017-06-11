DROP DATABASE on_line_store;
CREATE DATABASE on_line_store;
USE on_line_store;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE categories (id INT AUTO_INCREMENT, name VARCHAR(50), PRIMARY KEY (id)) ENGINE=MYISAM CHARACTER SET=UTF8; 

CREATE TABLE persons (id INT AUTO_INCREMENT, first_name VARCHAR(100), last_Name VARCHAR(50), email VARCHAR(50), 
             password VARCHAR(50), addresses_id INT, phone VARCHAR(15), groups VARCHAR(10), PRIMARY KEY(id), 
             FOREIGN KEY (addresses_id) REFERENCES addresses(id)) ENGINE=MyISAM CHARACTER SET=utf8; 
                     
CREATE TABLE products (id INT AUTO_INCREMENT,  name VARCHAR(50), description VARCHAR(1000), category_id INT,
			 price DOUBLE, residue INT, PRIMARY KEY(id))ENGINE=MyISAM CHARACTER SET=utf8;  
                        
 
CREATE TABLE customer_orders (id INT AUTO_INCREMENT, person_id INT, date_created DATE, 
			 date_closing DATE, orderstatus VARCHAR(10), PRIMARY KEY(id), FOREIGN KEY (person_id) REFERENCES persons(id)) 
             ENGINE=MyISAM CHARACTER SET=utf8; 
                                                        
CREATE TABLE order_items (id INT AUTO_INCREMENT, customer_order_id INT,  product_id INT, 
			 quantity INT, PRIMARY KEY(id), FOREIGN KEY (customer_order_id) REFERENCES customer_orders(id),
             FOREIGN KEY (product_id) REFERENCES products(id)) ENGINE=MyISAM CHARACTER SET=utf8;  
                        
CREATE TABLE addresses (id INT AUTO_INCREMENT, country VARCHAR(30), street VARCHAR(30), house INT, building INT, 
             apartment INT, city VARCHAR(20), zip VARCHAR(6), PRIMARY KEY(id))ENGINE=MyISAM CHARACTER SET=utf8; 
         
CREATE TABLE reviews (id INT AUTO_INCREMENT, comment VARCHAR(300), date_created_review DATE, article_id INT, PRIMARY KEY(id),
			 FOREIGN KEY (article_id) REFERENCES articles(id)) ENGINE=MyISAM CHARACTER SET=utf8;
             
CREATE TABLE persons_reviews (person_id INT, review_id INT, PRIMARY KEY(person_id, review_id),
			 FOREIGN KEY (person_id) REFERENCES persons(id),
             FOREIGN KEY (review_id) REFERENCES reviews(id))ENGINE=MyISAM CHARACTER SET=utf8;   
             
CREATE TABLE products_reviews (product_id INT, review_id INT, PRIMARY KEY(product_id, review_id),
			 FOREIGN KEY (product_id) REFERENCES products(id),
             FOREIGN KEY (review_id) REFERENCES reviews(id))ENGINE=MyISAM CHARACTER SET=utf8;       
             
CREATE TABLE promotions (id INT AUTO_INCREMENT, name VARCHAR(50), date_start DATE, date_end DATE,
             discount INT, KEY(id)) ENGINE=MyISAM CHARACTER SET=utf8;
             
CREATE TABLE products_promotions (product_id INT, promotion_id INT, PRIMARY KEY(product_id, promotion_id),
			 FOREIGN KEY (product_id) REFERENCES products(id),
             FOREIGN KEY (promotion_id) REFERENCES promotions(id))ENGINE=MyISAM CHARACTER SET=utf8;
             
CREATE TABLE articles (id INT AUTO_INCREMENT, name VARCHAR(50), text VARCHAR(300), date_created_article DATE, PRIMARY KEY(id))
             ENGINE=MyISAM CHARACTER SET=utf8;
             
             
             
INSERT INTO addresses (country, city, street, house, building, apartment, zip) 
             VALUES ('Беларусь', 'Минск', 'Голодеда', 5, 1, 75, '220066');   
             
INSERT INTO addresses (country, city, street, house, building, apartment, zip)
             VALUES ('Беларусь', 'Минск', 'Мирошниченко', 10, 1, 148, '220033'); 
             
INSERT INTO addresses (country, city, street, house, building, apartment, zip)
             VALUES ('Беларусь', 'Минск', 'Рокоссовского', 4, 4, 435, '220047');  
                   
INSERT INTO persons (first_name, last_Name, email, password, addresses_id, phone, groups) 
                  VALUES ('Максим', 'Долгорукий', 'dolgorukiy@bk.ru','1', 1, '+375297589843', 'USER'); 
    
INSERT INTO persons (first_name, last_Name, email, password, addresses_id, phone, groups) 
                  VALUES ('Егор', 'Миронов', 'mironov@bk.ru','2', 2, '+375296849032', 'USER'); 
                  
INSERT INTO persons (first_name, last_Name, email, password, addresses_id, phone, groups) 
                  VALUES ('Елена', 'Хмель', 'hemel@bk.ru','3', 3, '+375296849033', 'ADMIN');                  
             
            
        
             
             
            
                   
                        
 