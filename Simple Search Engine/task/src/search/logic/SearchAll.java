package search.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class SearchAll implements SearchMethod{
    private ArrayList< String> query;

    public SearchAll(ArrayList<String> query) {
        this.query = query;
    }

    @Override
    public HashSet<Integer> find(HashMap<String, HashSet<Integer>> map) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSetAll = new HashSet<>();
        for(HashSet<Integer> hash : map.values()){
            hashSetAll.addAll(hash);
        }
        for(String s:query){
            if(map.containsKey(s)){
                hashSet.addAll(map.get(s));
            }
            hashSetAll.retainAll(hashSet);
            hashSet.clear();
        }

        return hashSetAll;
    }


}
