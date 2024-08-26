package com.leetcode.lc2353;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Your FoodRatings object will be instantiated and called as such: FoodRatings obj = new
 * FoodRatings(foods, cuisines, ratings); obj.changeRating(food,newRating); String param_2 =
 * obj.highestRated(cuisine);
 */
class FoodRatings {

  private final HashMap<String, Integer> foodRatingMap;
  private final HashMap<String, String> foodCuisineMap;
  private final HashMap<String, PriorityQueue<Food>> cuisineFoodMap;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    foodRatingMap = new HashMap<>(foods.length);
    foodCuisineMap = new HashMap<>(cuisines.length);
    cuisineFoodMap = new HashMap<>(cuisines.length);

    for (int i = 0; i < foods.length; i++) {
      foodRatingMap.put(foods[i], ratings[i]);
      foodCuisineMap.put(foods[i], cuisines[i]);
      if (!cuisineFoodMap.containsKey(cuisines[i])) {
        cuisineFoodMap.put(cuisines[i], new PriorityQueue<>());
      }
      cuisineFoodMap.get(cuisines[i]).add(new Food(ratings[i], foods[i]));
    }
  }

  public void changeRating(String food, int newRating) {
    foodRatingMap.put(food, newRating);
    var cuisine = foodCuisineMap.get(food);
    cuisineFoodMap.get(cuisine).add(new Food(newRating, food));
  }

  public String highestRated(String cuisine) {
    Food highestRated = cuisineFoodMap.get(cuisine).peek();

    while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
      cuisineFoodMap.get(cuisine).poll();
      highestRated = cuisineFoodMap.get(cuisine).peek();
    }

    return highestRated.foodName;
  }

  private class Food implements Comparable<Food> {

    private final int foodRating;
    private final String foodName;

    public Food(int foodRating, String foodName) {
      this.foodRating = foodRating;
      this.foodName = foodName;
    }

    @Override
    public int compareTo(Food o) {
      if (foodRating == o.foodRating) {
        return foodName.compareTo(o.foodName);
      }
      return -1 * Integer.compare(foodRating, o.foodRating);
    }
  }
}

