package com.leetcode.lc1472;

import java.util.ArrayList;
import java.util.List;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
public class BrowserHistory {
  private final List<String> urls;
  private int position;

  public BrowserHistory(String homepage) {
    urls = new ArrayList<>();
    urls.add(homepage);
    position = 0;
  }

  public void visit(String url) {
    while (urls.size() > position + 1) {
      urls.remove(urls.size() - 1);
    }
    urls.add(url);
    position++;
  }

  public String back(int steps) {
    position = Math.max(0, position - steps);
    return urls.get(position);
  }

  public String forward(int steps) {
    position = Math.min(urls.size() - 1, position + steps);
    return urls.get(position);
  }
}
