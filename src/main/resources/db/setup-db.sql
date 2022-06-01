create database onboardingdb;
create user if not exists 'doctor_admin'@'localhost' identified by 'Doctor';
grant all privileges on onboardingdb.* to 'doctor_admin'@'localhost';
flush privileges;