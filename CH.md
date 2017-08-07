## Company House

### Clean CSV Headers

```csv
CompanyName,CompanyNumber,RegAddressCareOf,RegAddressPOBox,RegAddressAddressLine1,RegAddressAddressLine2,RegAddressPostTown,RegAddressCounty,RegAddressCountry,RegAddressPostCode,CompanyCategory,CompanyStatus,CountryOfOrigin,DissolutionDate,IncorporationDate,AccountsAccountRefDay,AccountsAccountRefMonth,AccountsNextDueDate,AccountsLastMadeUpDate,AccountsAccountCategory,ReturnsNextDueDate,ReturnsLastMadeUpDate,MortgagesNumMortCharges,MortgagesNumMortOutstanding,MortgagesNumMortPartSatisfied,MortgagesNumMortSatisfied,SICCodeSicText_1,SICCodeSicText_2,SICCodeSicText_3,SICCodeSicText_4,LimitedPartnershipsNumGenPartners,LimitedPartnershipsNumLimPartners,URI,PreviousName_1CONDATE,PreviousName_1CompanyName,PreviousName_2CONDATE,PreviousName_2CompanyName,PreviousName_3CONDATE,PreviousName_3CompanyName,PreviousName_4CONDATE,PreviousName_4CompanyName,PreviousName_5CONDATE,PreviousName_5CompanyName,PreviousName_6CONDATE,PreviousName_6CompanyName,PreviousName_7CONDATE,PreviousName_7CompanyName,PreviousName_8CONDATE,PreviousName_8CompanyName,PreviousName_9CONDATE,PreviousName_9CompanyName,PreviousName_10CONDATE,PreviousName_10CompanyName,ConfStmtNextDueDate,ConfStmtLastMadeUpDate
```

### Hive Table Definition

```SQL
create table company_house
(CompanyName string,
CompanyNumber string,
RegAddressCareOf string,
RegAddressPOBox string,
RegAddressAddressLine1 string,
RegAddressAddressLine2 string,
RegAddressPostTown string,
RegAddressCounty string,
RegAddressCountry string,
RegAddressPostCode string,
CompanyCategory string,
CompanyStatus string,
CountryOfOrigin string,
DissolutionDate string,
IncorporationDate string,
AccountsAccountRefDay string,
AccountsAccountRefMonth string,
AccountsNextDueDate string,
AccountsLastMadeUpDate string,
AccountsAccountCategory string,
ReturnsNextDueDate string,
ReturnsLastMadeUpDate string,
MortgagesNumMortCharges string,
MortgagesNumMortOutstanding string,
MortgagesNumMortPartSatisfied string,
MortgagesNumMortSatisfied string,
SICCodeSicText1 string,
SICCodeSicText2 string,
SICCodeSicText3 string,
SICCodeSicText4 string,
LimitedPartnershipsNumGenPartners string,
LimitedPartnershipsNumLimPartners string,
URI,PreviousName1CONDATE string,
PreviousName1CompanyName string,
PreviousName2CONDATE string,
PreviousName2CompanyName string,
PreviousName3CONDATE string,
PreviousName3CompanyName string,
PreviousName4CONDATE string,
PreviousName4CompanyName string,
PreviousName5CONDATE string,
PreviousName5CompanyName string,
PreviousName6CONDATE string,
PreviousName6CompanyName string,
PreviousName7CONDATE string,
PreviousName7CompanyName string,
PreviousName8CONDATE string,
PreviousName8CompanyName string,
PreviousName9CONDATE string,
PreviousName9CompanyName string,
PreviousName10CONDATE string,
PreviousName10CompanyName string,
ConfStmtNextDueDate string,
ConfStmtLastMadeUpDate string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
TBLPROPERTIES("skip.header.line.count"="1");
```