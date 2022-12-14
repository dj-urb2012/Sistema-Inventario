create database DBRepuestosTorres

go

use DBRepuestosTorres
go

/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 15.0 		*/
/*  Created On : 29-nov.-2022 16:01:47 				*/
/*  DBMS       : SQL Server 2012 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Product]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Product]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[User]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [User]
GO

/* Create Tables */

CREATE TABLE [Product]
(
	[ProductID] int NOT NULL IDENTITY (1, 1),
	[Id] nvarchar(50) NULL,
	[Name] nvarchar(50) NULL,
	[Brand] nvarchar NULL,
	[Category] nvarchar NULL,
	[Price] decimal(18,2) NULL,
	[Stock] int NULL
)
GO

CREATE TABLE [User]
(
	[UserID] int NOT NULL IDENTITY (1, 1),
	[Username] nvarchar(50) NULL,
	[Password] nvarchar(50) NULL
)
GO

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE [Product] 
 ADD CONSTRAINT [PK_Product]
	PRIMARY KEY CLUSTERED ([ProductID] ASC)
GO

ALTER TABLE [User] 
 ADD CONSTRAINT [PK_User]
	PRIMARY KEY CLUSTERED ([UserID] ASC)
GO
