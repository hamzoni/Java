USE [master]
GO
/****** Object:  Database [Supermarket]    Script Date: 8/17/2017 4:50:11 PM ******/
CREATE DATABASE [Supermarket]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Supermarket', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Supermarket.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Supermarket_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Supermarket_log.ldf' , SIZE = 4672KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Supermarket] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Supermarket].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Supermarket] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Supermarket] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Supermarket] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Supermarket] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Supermarket] SET ARITHABORT OFF 
GO
ALTER DATABASE [Supermarket] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Supermarket] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Supermarket] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Supermarket] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Supermarket] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Supermarket] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Supermarket] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Supermarket] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Supermarket] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Supermarket] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Supermarket] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Supermarket] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Supermarket] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Supermarket] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Supermarket] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Supermarket] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Supermarket] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Supermarket] SET RECOVERY FULL 
GO
ALTER DATABASE [Supermarket] SET  MULTI_USER 
GO
ALTER DATABASE [Supermarket] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Supermarket] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Supermarket] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Supermarket] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Supermarket] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Supermarket]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[product_id] [int] NULL,
	[invoice_id] [int] NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [float] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Client]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Client](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
	[address] [text] NULL,
	[date_create] [datetime] NOT NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[payment_method] [nvarchar](max) NOT NULL,
	[date_create] [datetime] NOT NULL,
	[user_id] [int] NULL,
	[client_id] [int] NULL,
 CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[price] [float] NOT NULL,
	[category_id] [int] NULL,
	[stock_id] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Stock]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stock](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[cost] [float] NOT NULL,
	[origin] [nvarchar](max) NULL,
	[producer] [nvarchar](max) NOT NULL,
	[remaining] [int] NULL,
	[stock_out] [int] NULL,
	[last_import_date] [datetime] NULL,
	[last_export_date] [datetime] NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](max) NOT NULL,
	[username] [nvarchar](max) NOT NULL,
	[password] [nvarchar](max) NOT NULL,
	[privilege] [int] NOT NULL,
	[date_create] [datetime] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Index [IX_Users]    Script Date: 8/17/2017 4:50:11 PM ******/
CREATE NONCLUSTERED INDEX [IX_Users] ON [dbo].[Users]
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_cart_invoiceID] FOREIGN KEY([invoice_id])
REFERENCES [dbo].[Invoice] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_cart_invoiceID]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_cart_productID] FOREIGN KEY([product_id])
REFERENCES [dbo].[Product] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_cart_productID]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Client] FOREIGN KEY([client_id])
REFERENCES [dbo].[Client] ([id])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Bill_Client]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [fk_invoice_clientID] FOREIGN KEY([client_id])
REFERENCES [dbo].[Client] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [fk_invoice_clientID]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [fk_invoice_userID] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [fk_invoice_userID]
GO
/****** Object:  StoredProcedure [dbo].[countRecords]    Script Date: 8/17/2017 4:50:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[countRecords]
@table varchar(50)
AS
BEGIN

DECLARE @command AS NVARCHAR(max)
SET @command = 'SELECT COUNT(*) AS result FROM ' + @table
EXEC sp_executesql @command 

END
GO
USE [master]
GO
ALTER DATABASE [Supermarket] SET  READ_WRITE 
GO
