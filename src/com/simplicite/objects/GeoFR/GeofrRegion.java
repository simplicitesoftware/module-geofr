package com.simplicite.objects.GeoFR;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

import com.simplicite.util.AppLog;
import com.simplicite.util.ObjectService;
import com.simplicite.util.ObjectField;
import com.simplicite.util.Tool;
import com.simplicite.util.tools.RESTTool;

/**
 * Region (France)
 */
public class GeofrRegion extends ObjectService {
	private static final long serialVersionUID = 1L;
	
	private boolean m_debug = false;
	
	private String m_url = null;
	
	@Override
	public void postLoad() {
		String cfg = getSearchSpec();
		try {
			m_config = new JSONObject(Tool.isEmpty(cfg) ? "{}" : cfg);
		} catch (Exception e) {
			AppLog.error("Configuration is not a JSON object: " + cfg, e, getGrant());
			m_config = new JSONObject();
		}
		m_url = m_config.optString("url", "https://geo.api.gouv.fr/regions");
	}

	private JSONArray list = null;
	
	@Override
	public long countService() {
		try {
			StringBuilder flt = new StringBuilder();
			for (ObjectField f : getFields()) {
				if (!f.isTechnicalField() && !Tool.isEmpty(f.getColumn())
				 && !Tool.isEmpty(f.getFilter()) && !ObjectField.DEFAULT_FILTER.equals(f.getFilter())) {
					flt.append(flt.length() == 0 ?  "?" : "&");
					flt.append(f.getColumn() + "=" + Tool.toHTTP(f.getFilter()));
				}
			}

			String res = RESTTool.get(m_url + flt);
			if (m_debug)
				AppLog.info("API call result = " + res, getGrant());
			list = new JSONArray(res);
			if (m_debug)
				AppLog.info("List = " + list.toString(), getGrant());
			return list.length();
		}
		catch (Exception e)
		{
			AppLog.error(null, e, getGrant());
			return 0;
		}
	}

	@Override
	public List<String[]> searchService(boolean pagine) {
		List<String[]> rows = new ArrayList<>();

		for (int i = 0; i < list.length(); i++) {
			JSONObject item = list.getJSONObject(i);
			if (m_debug)
				AppLog.info("Item " + i + " = " + item.toString(), getGrant());
			String[] row = new String[getFields().size()];
			for (ObjectField f : getFields()) {
				row[f.getIndex(this)] = item.optString(f.getColumn());
			}
			rows.add(row);
		}
		
		return rows;
	}
	
	@Override
	public boolean selectService(String rowId, boolean copy) {
		// TODO
		return true;
	}


	@Override
	public String getUserKeyLabel(String[] row) {
		return row != null
			? row[getFieldIndex("geofrRegName")]
			: getFieldValue("geofrRegName");
	}
}
