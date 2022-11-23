CREATE DATABASE InventoryBD
GO

USE InventoryBD
GO

CREATE TABLE Products(
	idProduct nvarchar(30) NOT NULL primary key,
	productName nvarchar(40) NOT NULL,
	productBrand nvarchar(40) NOT NULL,
	productType nvarchar(40) NOT NULL,
	productPrice decimal(10, 2) NOT NULL DEFAULT 0,
	productStock int NOT NULL DEFAULT 0
)
GO

CREATE TABLE appUser(
	userName nvarchar(60) NOT NULL,
	userPassword nvarchar(60) NOT NULL,
	userIsRegistered bit DEFAULT 'false'
)
GO

CREATE TABLE ProductRecords(
	productName nvarchar(40) NOT NULL,
	productBrand nvarchar(40) NOT NULL,
	recordType nvarchar(5) NOT NULL,
	numberProducts int NOT NULL,
	productPrice decimal(10, 2) NOT NULL
)
GO