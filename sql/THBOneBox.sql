DROP TABLE [dbo].[OneBoxRecord]

--==============================================================
-- Table: OneBoxRecord
--==============================================================
CREATE TABLE [dbo].[OneBoxRecord](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[QUERY] [varchar](255) NULL,
	[USER_NAME] [varchar](255) NULL,
	[IP_ADDR] [varchar](50) NULL,
	[DATE_TIME] [varchar](50) NULL,
	[AUTH_TYPE] [varchar](50) NULL,
	[LANG] [varchar](50) NULL,
	[ONE_BOX_NAME] [varchar](100) NULL,
	[API_MAJ] [varchar](50) NULL,
	[API_MIN] [varchar](50) NULL,
	[DOMAIN] [varchar](255) NULL,
	[CREATE_TIME] [datetime] NOT NULL
 CONSTRAINT [PK_OneBoxRecord] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]