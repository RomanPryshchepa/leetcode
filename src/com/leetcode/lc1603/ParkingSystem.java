package com.leetcode.lc1603;

/**
 * Your ParkingSystem object will be instantiated and called as such: ParkingSystem obj = new
 * ParkingSystem(big, medium, small); boolean param_1 = obj.addCar(carType);
 */
class ParkingSystem {

  private int bigCount;
  private int mediumCount;
  private int smallCount;

  public ParkingSystem(int big, int medium, int small) {
    bigCount = big;
    mediumCount = medium;
    smallCount = small;
  }

  public boolean addCar(int carType) {
    switch (carType) {
      case 1:
        if (bigCount == 0) {
          return false;
        }
        bigCount--;
        return true;
      case 2:
        if (mediumCount == 0) {
          return false;
        }
        mediumCount--;
        return true;
      case 3:
        if (smallCount == 0) {
          return false;
        }
        smallCount--;
        return true;
    }
    return false;
  }
}