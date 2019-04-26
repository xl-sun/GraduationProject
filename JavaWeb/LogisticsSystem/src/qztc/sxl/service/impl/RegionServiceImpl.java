package qztc.sxl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import qztc.sxl.dao.DAOFactory;
import qztc.sxl.dao.RegionDAO;
import qztc.sxl.pojo.Region;
import qztc.sxl.service.RegionService;

public class RegionServiceImpl implements RegionService{

	@Override
	public List<String> getNamesByLevle(int level) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		RegionDAO regiondao = DAOFactory.getRegionDAO();
		
		
		try {
			list = regiondao.getRegionNamesByLevel(level);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list.add("获取失败");
		}

		System.out.println(list);  
		return list;
	}

	@Override
	public List<Region> getRegionsByLevle(int level) {
		// TODO Auto-generated method stub
		List<Region> list = null;
		RegionDAO regiondao = DAOFactory.getRegionDAO();

		try {
			list = regiondao.getRegionsByLevel(level);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public JSONObject getRegionsByPid(String pid) {
		// TODO Auto-generated method stub
		//JSONObject json = new JSONObject();
		List<Region> list = new ArrayList<Region>();
		//List<String> list = new ArrayList<String>();
		Map<String,String> map = new HashMap<String,String>();
		RegionDAO regiondao = DAOFactory.getRegionDAO();

		try {
			list = regiondao.getRegionsByPid(pid);
			for( int i = 0 ; i < list.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
				map.put(list.get(i).getId(), list.get(i).getRegionName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JSONObject(map);
	}

	@Override
	public String getMergerNameById(String id) {
		// TODO Auto-generated method stub
		String mergerName="";
		RegionDAO regiondao = DAOFactory.getRegionDAO();

		try {
			mergerName = regiondao.getMergerNameById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mergerName);
		return mergerName;
	}

}
