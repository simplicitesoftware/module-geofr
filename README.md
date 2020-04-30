<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`GeoFR` module definition
=========================

France geographical business objects

`GeoFRCity` business object definition
--------------------------------------

Commune

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `geofrCitName`                                               | char(100)                                | yes      | yes       |          | Commune name                                                                     |
| `geofrCitCodePostal`                                         | regexp(5)                                |          | yes       |          | Code postal                                                                      |
| `geofrCitCodeINSEE`                                          | char(5)                                  | yes*     | yes       |          | Code INSEE                                                                       |
| `geofrCitCoordinates`                                        | geocoords                                |          | yes       |          | Coordinates                                                                      |
| `geofrCitDepId` link to **`GeoFRDepartment`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `geofrCitDepId.geofrDepCode`_                          | _regexp(3)_                              |          |           |          | _Department code_                                                                |
| _Ref. `geofrCitDepId.geofrDepName`_                          | _char(100)_                              |          |           |          | _Department name_                                                                |
| _Ref. `geofrCitDepId.geofrDepRegId`_                         | _id_                                     |          |           |          | -                                                                                |
| _Ref. `geofrDepRegId.geofrRegCode`_                          | _regexp(3)_                              |          |           |          | _Region code_                                                                    |
| _Ref. `geofrDepRegId.geofrRegNom`_                           | _char(100)_                              |          |           |          | _Region name_                                                                    |

`GeoFRDepartment` business object definition
--------------------------------------------

Department (France)

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `geofrDepCode`                                               | regexp(3)                                | yes*     | yes       |          | Department code                                                                  |
| `geofrDepName`                                               | char(100)                                | yes      | yes       |          | Department name                                                                  |
| `geofrDepRegId` link to **`GeofrRegion`**                    | id                                       |          | yes       |          | -                                                                                |
| _Ref. `geofrDepRegId.geofrRegCode`_                          | _regexp(3)_                              |          |           |          | _Region code_                                                                    |
| _Ref. `geofrDepRegId.geofrRegNom`_                           | _char(100)_                              |          |           |          | _Region name_                                                                    |

`GeofrRegion` business object definition
----------------------------------------

Region (France)

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `geofrRegNom`                                                | char(100)                                | yes      | yes       |          | Region name                                                                      |

