package myproject.vo;
public class UserInfodb {
    private String robotId;
    private boolean state;
    private String realtimeMap;
    private String pictures;
    private float averageMazeExplorationTime;
    private int explorationTimes;
    private int statisticsOfTreasures;

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getRealtimeMap() {
        return realtimeMap;
    }

    public void setRealtimeMap(String realtimeMap) {
        this.realtimeMap = realtimeMap;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public float getAverageMazeExplorationTime() {
        return averageMazeExplorationTime;
    }

    public void setAverageMazeExplorationTime(float averageMazeExplorationTime) {
        this.averageMazeExplorationTime = averageMazeExplorationTime;
    }

    public int getExplorationTimes() {
        return explorationTimes;
    }

    public void setExplorationTimes(int explorationTimes) {
        this.explorationTimes = explorationTimes;
    }

    public int getStatisticsOfTreasures() {
        return statisticsOfTreasures;
    }

    public void setStatisticsOfTreasures(int statisticsOfTreasures) {
        this.statisticsOfTreasures = statisticsOfTreasures;
    }
}
