package io;

import java.util.prefs.Preferences;

import static utils.PrintUtil.println;

public class PreferencesDemo {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            println(key + ": " + prefs.get(key, null));
        }
        // You must always provide a default value:
        println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }
} /* Output: (Sample)
  Location: Oz
  Footwear: Ruby Slippers
  Companions: 4
  Are there witches?: true
  UsageCount: 53
  How many companions does Dorothy have? 4
  *///:~
