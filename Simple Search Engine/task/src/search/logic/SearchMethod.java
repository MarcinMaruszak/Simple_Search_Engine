package search.logic;
import java.util.HashMap;
import java.util.HashSet;

public interface SearchMethod {


    HashSet<Integer> find(HashMap<String, HashSet<Integer>> map);
}
