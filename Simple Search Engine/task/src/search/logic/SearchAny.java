package search.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class SearchAny implements SearchMethod {
    private ArrayList<String> query;

    public SearchAny(ArrayList<String> query) {
        this.query = query;
    }

    @Override
    public HashSet<Integer> find(HashMap<String, HashSet<Integer>> map) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(String s: query){
            if(map.containsKey(s)){
                hashSet.addAll(map.get(s));
            }
        }
        return hashSet;
    }
}
