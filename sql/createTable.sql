/* Setting up mediscreen DB */

DROP TABLE if EXISTS patients;

CREATE TABLE patients(
  id INT AUTO_INCREMENT,
  last_name VARCHAR(25) NOT NULL,
  first_name VARCHAR(25) NOT NULL,
  date_of_birth VARCHAR(10),
  sex VARCHAR(1),
  address VARCHAR(65) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
  );
