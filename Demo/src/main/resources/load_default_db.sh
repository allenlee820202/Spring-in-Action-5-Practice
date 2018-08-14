mysql -u root -p -e "create database tacocloud"
mysql -u root -p tacocloud < mysql-schema.sql
mysql -u root -p tacocloud < ingredients.sql
