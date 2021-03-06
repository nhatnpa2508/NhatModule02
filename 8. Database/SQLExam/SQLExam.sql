USE [master]
GO
/****** Object:  Database [example]    Script Date: 6/8/2019 4:47:22 PM ******/
CREATE DATABASE [example]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'example', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\example.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'example_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\example_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [example] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [example].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [example] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [example] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [example] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [example] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [example] SET ARITHABORT OFF 
GO
ALTER DATABASE [example] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [example] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [example] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [example] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [example] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [example] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [example] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [example] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [example] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [example] SET  DISABLE_BROKER 
GO
ALTER DATABASE [example] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [example] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [example] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [example] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [example] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [example] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [example] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [example] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [example] SET  MULTI_USER 
GO
ALTER DATABASE [example] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [example] SET DB_CHAINING OFF 
GO
ALTER DATABASE [example] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [example] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [example] SET DELAYED_DURABILITY = DISABLED 
GO
USE [example]
GO
/****** Object:  Table [dbo].[cust]    Script Date: 6/8/2019 4:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cust](
	[customerNumber] [int] NOT NULL,
	[customerName] [char](50) NOT NULL,
	[contactLastName] [varchar](50) NOT NULL,
	[contactFirstName] [varchar](50) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[addressLine1] [varchar](50) NOT NULL,
	[addressLine2] [varchar](50) NULL DEFAULT (NULL),
	[city] [varchar](50) NOT NULL,
	[state] [varchar](50) NULL DEFAULT (NULL),
	[postalCode] [varchar](15) NULL DEFAULT (NULL),
	[country] [varchar](50) NOT NULL,
	[salesRepEmployeeNumber] [int] NULL DEFAULT (NULL),
	[creditLimit] [decimal](10, 2) NULL DEFAULT (NULL)
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[customer]    Script Date: 6/8/2019 4:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[customerNumber] [int] NOT NULL,
	[customerName] [char](50) NOT NULL,
	[contactLastName] [varchar](50) NOT NULL,
	[contactFirstName] [varchar](50) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[addressLine1] [varchar](50) NOT NULL,
	[addressLine2] [varchar](50) NULL DEFAULT (NULL),
	[city] [varchar](50) NOT NULL,
	[state] [varchar](50) NULL DEFAULT (NULL),
	[postalCode] [varchar](15) NULL DEFAULT (NULL),
	[country] [varchar](50) NOT NULL,
	[salesRepEmployeeNumber] [int] NULL DEFAULT (NULL),
	[creditLimit] [decimal](10, 2) NULL DEFAULT (NULL)
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 6/8/2019 4:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customers](
	[customerNumber] [int] NOT NULL,
	[customerName] [varchar](50) NOT NULL,
	[contactLastName] [varchar](50) NOT NULL,
	[contactFirstName] [varchar](50) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[addressLine1] [varchar](50) NOT NULL,
	[addressLine2] [varchar](50) NULL,
	[city] [varchar](50) NOT NULL,
	[state] [varchar](50) NULL,
	[postalCode] [varchar](15) NULL,
	[country] [varchar](50) NOT NULL,
	[salesRepEmployeeNumber] [int] NULL,
	[creditLimit] [decimal](10, 2) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Table_Student]    Script Date: 6/8/2019 4:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Table_Student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[address] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NULL,
	[mark] [float] NULL,
 CONSTRAINT [PK_Table_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (NULL) FOR [addressLine2]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (NULL) FOR [state]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (NULL) FOR [postalCode]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (NULL) FOR [salesRepEmployeeNumber]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (NULL) FOR [creditLimit]
GO
USE [master]
GO
ALTER DATABASE [example] SET  READ_WRITE 
GO
