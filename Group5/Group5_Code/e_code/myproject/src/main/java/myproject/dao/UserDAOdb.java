package myproject.dao;

import myproject.vo.*;

public interface UserDAOdb {
	public UserInfodb getRobotRecordByUsername(String username) throws Exception;
}
