package myproject.dao;


import myproject.vo.UserInfo;

public interface RobotDAO {
	public void deleteRobotInfo (String robotid) throws Exception;
	public void addRobotInfo (String robotid, Boolean state, String realtimeMap, String pictures, Float averageMazeExplorationTime, int explorationTimes, int statisticsOfTreasures) throws Exception;
	
	
}
