package cache.dao;

import cache.domain.Dom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 09.07.15.
 */
public class Dao {
    public static List<Dom> listt = new ArrayList<>();

    public Dao() {
        listt.add(new Dom(1L, "a", "a", 100L));
        listt.add(new Dom(2L, "b", "a", 200L));
        listt.add(new Dom(3L, "c", "a", 300L));
        listt.add(new Dom(4L, "d", "a", 400L));
        listt.add(new Dom(5L, "e", "a", 500L));
        listt.add(new Dom(6L, "f", "a", 600L));
        listt.add(new Dom(7L, "g", "a", 700L));
        listt.add(new Dom(8L, "h", "a", 800L));
        listt.add(new Dom(9L, "ai", "a", 900L));
        listt.add(new Dom(10L, "ad", "a", 1100L));
        listt.add(new Dom(11L, "afa", "a", 2100L));
        listt.add(new Dom(12L, "agg", "a", 1300L));
        listt.add(new Dom(13L, "aett", "a", 1400L));
        listt.add(new Dom(14L, "afga", "a", 1500L));
        listt.add(new Dom(15L, "ahjg", "a", 1600L));
        listt.add(new Dom(16L, "anb", "a", 1070L));
        listt.add(new Dom(17L, "avx", "a", 1080L));
        listt.add(new Dom(18L, "asdf", "a", 1900L));
        listt.add(new Dom(19L, "asdf", "a", 1000L));
        listt.add(new Dom(20L, "aadf", "a", 1080L));
        listt.add(new Dom(21L, "afds", "a", 1050L));
        listt.add(new Dom(22L, "adf", "a", 1003L));
    }

}
