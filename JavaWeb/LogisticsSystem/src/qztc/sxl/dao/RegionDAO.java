package qztc.sxl.dao;

import java.util.List;

import qztc.sxl.pojo.Region;

public interface RegionDAO {
	public List<Region> getRegionsByLevel(int level) throws Exception;
	public List<String> getRegionNamesByLevel(int level) throws Exception;
	public List<Region> getRegionsByPid(String pid) throws Exception;
	public String getMergerNameById(String id) throws Exception;
	public Region getRegionById(int level) throws Exception;
	public String getIdByMergerName(String mergername) throws Exception;
}
