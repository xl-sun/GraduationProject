package qztc.sxl.service;

import java.util.List;

import org.json.JSONObject;

import qztc.sxl.pojo.Region;

public interface RegionService {
	public List<String> getNamesByLevle(int level);
	public List<Region> getRegionsByLevle(int level);
	public JSONObject getRegionsByPid(String pid);
	public String getMergerNameById(String id);
}
