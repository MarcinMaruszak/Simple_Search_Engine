package search.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SearchNone implements SearchMethod{
    private ArrayList<String> query;

    public SearchNone(ArrayList<String> query) {
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

        HashSet<Integer> hashSetAll = new HashSet<>();
        for(HashSet<Integer> hash : map.values()){
            hashSetAll.addAll(hash);
        }
        hashSetAll.removeAll(hashSet);
        return hashSetAll;
    }
}
