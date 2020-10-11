package search.logic;

import java.util.HashMap;
import java.util.HashSet;

public class SearchContext {
    private SearchMethod searchMethod;


    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public HashSet<Integer> search(HashMap<String,HashSet<Integer>> map){
        return searchMethod.find(map);
    }
}
