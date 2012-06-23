CREATE TABLE location
     (  longitude decimal(10,6) NOT NULL, 
        latitude decimal(10,6) NOT NULL,
        name varchar(50) NOT NULL, 
        is_building boolean NOT NULL,
        PRIMARY KEY (longitude, latitude));