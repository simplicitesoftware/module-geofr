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

`GeofrRegion` business object definition
----------------------------------------

Region (France)

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `geofrRegName`                                               | char(100)                                | yes      | yes       |          | Region name                                                                      |

`GeofrDepartment` business object definition
--------------------------------------------

Department (France)

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `geofrDepName`                                               | char(100)                                | yes      | yes       |          | Department name                                                                  |

`GeofrCity` business object definition
--------------------------------------

Commune

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `geofrCitName`                                               | char(100)                                | yes      | yes       |          | Commune name                                                                     |
| `geofrCitCodePostal`                                         | regexp(5)                                |          | yes       |          | Code postal                                                                      |
| `geofrCitCodeINSEE`                                          | char(5)                                  | yes*     | yes       |          | Code INSEE                                                                       |
| `geofrCitCoordinates`                                        | geocoords                                |          | yes       |          | Coordinates                                                                      |
| `geofrCitDepId` link to **`GeofrDepartment`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `geofrCitDepId.geofrDepCode`_                          | _regexp(3)_                              |          |           |          | _Department code_                                                                |
| _Ref. `geofrCitDepId.geofrDepName`_                          | _char(100)_                              |          |           |          | _Department name_                                                                |
| `geofrRegCode` link to **`GeofrRegion`**                     | regexp(3)                                | yes*     | yes       |          | Region code                                                                      |
| `geofrRegName` link to **`GeofrRegion`**                     | char(100)                                | yes      | yes       |          | Region name                                                                      |

