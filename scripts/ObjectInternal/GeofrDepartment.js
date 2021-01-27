GeoFRDepartment.getUserKeyLabel = function(row) {
	if (row)
		return row[this.getFieldIndex("geofrDepName")];
	else
		return this.getFieldValue("geofrDepName");
};