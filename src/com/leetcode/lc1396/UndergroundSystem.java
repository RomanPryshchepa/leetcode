package com.leetcode.lc1396;

import com.leetcode.tools.Pair;
import java.util.HashMap;

/**
 * Your UndergroundSystem object will be instantiated and called as such: UndergroundSystem obj =
 * new UndergroundSystem(); obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double
 * param_3 = obj.getAverageTime(startStation,endStation);
 */
class UndergroundSystem {

  private final HashMap<Integer, Pair<String, Integer>> checkInStations;
  private final HashMap<String, Pair<Integer, Integer>> stations;

  public UndergroundSystem() {
    checkInStations = new HashMap<>();
    stations = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    checkInStations.put(id, new Pair<>(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    if (checkInStations.containsKey(id)) {
      var startStation = checkInStations.get(id).firstItem();
      var startTime = checkInStations.get(id).secondItem();
      if (stations.containsKey(startStation + "-" + stationName)) {
        var time = stations.get(startStation + "-" + stationName).firstItem();
        var count = stations.get(startStation + "-" + stationName).secondItem();
        stations.put(startStation + "-" + stationName, new Pair<>(time + t - startTime, count + 1));
      } else {
        stations.put(startStation + "-" + stationName, new Pair<>(t - startTime, 1));
      }
      checkInStations.remove(id);
    }
  }

  public double getAverageTime(String startStation, String endStation) {
    if (stations.containsKey(startStation + "-" + endStation)) {
      return stations.get(startStation + "-" + endStation).firstItem() / (1.0d * stations.get(
          startStation + "-" + endStation).secondItem());
    }
    return 0;
  }
}