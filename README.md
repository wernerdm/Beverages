# Beverages

Werner De Mulder - Informatie omtrent backend applicatie voor interactie met database via REST API.
Benodigde tijd (schatting aangezien geen ervaring hiermee - wel leuke opdracht): 
- Opzoekingswerk - 1 dag.
- Implementatie + testen - 1 dag.


De applicatie werd gebouwd met Java. Hiervoor heb ik Eclipse gebruikt.
Voor het bouwen van de REST API heb ik het Spring boot Java framework gebruikt.
Om van start te gaan heb ik de basis van de applicatie gemaakt door middel van Spring Initializr (https://start.spring.io/).
De applicatie maakt verbinding met een SQL database. Hiervoor heb ik een lokale SQL Express (free version) toegepast en een database aangemaakt met de gevraagde Beverage gegevens.
Hieronder kan u het SQL statement terugvinden dat ik heb gebruikt voor het aanmaken van de tabel.


USE [Beverage]
GO

/****** Object:  Table [dbo].[beverages]    Script Date: 14/06/2021 16:59:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[beverages](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[Alcohol_percentage] [numeric](4, 2) NULL,
	[Creation_date] [datetime] NULL,
 CONSTRAINT [PK_beverages] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[beverages] ADD  CONSTRAINT [DF_beverages_Creation_date]  DEFAULT (getdate()) FOR [Creation_date]
GO


Eens de tabel gemaakt. Heb ik binnen SQL voor test doeleinden wat entries in de tabel gestopt.
Dit kan met onderstaande SQL commando.
  
  insert into beverages(Name, Description)
  values('Limonade','Fruitige drank')

  insert into beverages(Name, Description, Alcohol_percentage)
  values('Pastis','La Douce France op zijn best','48')
  
Bovenstaande testen werden uitgevoerd om te voldoen aan de vereisten opgesteld in de opdracht. Creation date_time wordt automatisch ingevuld in tabel. Verder is het alcohol percentage geen vereiste.


Starten van Java Applicatie.
Rechtermuisklik op BeverageAPI -> Run As -> Spring Boot App
Eens de Spring Boot App gestart is kunnen de onderstaande operaties toegepast worden via de browser van de PC.
Randvoorwaarde: SQL tabel moet lokaal beschikbaar zijn. 
SQL Connectie string kan aangepast worden via file application.properties onder src/main/resources
Standaard worden onderstaande parameters toegepast.
	spring.datasource.url=jdbc:sqlserver://localhost:1433;database=Beverage;		-- Connection string. SQL draait op poort 1433. Database name = Beverage
	spring.datasource.username=testaccount							-- username (SQL authentication) om Beverage tabel te benaderen
	spring.datasource.password=Service123							-- overeenkomende wachtwoord voor testaccount


**Operatie 1
Gelijkaardige acties, zoals bovenstaande zijn ook mogelijk via de URL van de browser.
Een lijst met alle beverages beschikbaar in de SQL tabel kan opgevraagd worden op onderstaande manier.
http://localhost:8080/api/beverages/


**Operatie 2
Bevragen van een specifieke beverage door het meegeven van een id. In onderstaande voorbeeld is dit id '1'.
http://localhost:8080/api/beverages/1

Beverages kunnen aangemaakt worden door Postman te installeren. De tool kan gratis gedownload worden via deze link (https://www.postman.com/downloads/).
Een Postman beschikbaar, kunnen entries toegevoegd worden aan de database door binnen de workspace van Postman een HTTP POST operatie te kiezen.
Bij de POST HTTP operatie dient de volgende URL gebruikt te worden:
localhost:8080/api/beverages
Binnen de body van het bericht selecteer je 'form-data' en kan je verschillende keys meegeven.
Voor het toevoegen van een entry zijn volgende keys verplicht:
Name
Description

Voor deze entries dien je vervolgens values mee te geven welke vervolgens in de database bewaard worden.
voorbeeld:
Name				        'Kasteelbier'						      MANDATORY FIELD
Description			    'Lekker belgisch biertje'			MANDATORY FIELD
Alcohol_percentage	'12'								          OPTIONAL FIELD - Indien deze parameter niet wordt meegegeven blijft het veld leeg (null value) in de database.


**Operatie 3
Laatste operatie is het verwijderen van een beverage uit de database via de RESt API.
Ook hier geldt dat de Postman gebruikt dient te worden.
Hier kiest je als HTTP operatie 'DELETE', als URL geef je onderstaande informatie mee.
localhost:8080/api/beverages/{id}
De {id} parameter geeft aan welke entry je wenst te verwijderen in de database.
Voorbeeld: localhost:8080/api/beverages/2









