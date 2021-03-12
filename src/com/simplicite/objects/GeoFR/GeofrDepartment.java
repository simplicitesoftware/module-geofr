package com.simplicite.objects.GeoFR;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * French department
 */
public class GeofrDepartment extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getUserKeyLabel(String[] row) {
		return getFieldValue("geofrDepName", row);
	}
}
