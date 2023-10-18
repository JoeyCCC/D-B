package myproject.dao;

import myproject.vo.*;

public interface UserDAO {
	public int queryByUserInfo (UserInfo userinfo) throws Exception;
}

