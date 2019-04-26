package qztc.sxl.dao;

import qztc.sxl.pojo.Position;

public interface PositionDAO {
	public int save(Position position) throws Exception;
	public Position findByName(String name) throws Exception;
	public int update(Position position) throws Exception;
}
