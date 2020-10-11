package search.domain;

import search.logic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataBase {
    private final ArrayList<String> dataBase;
    private final File file;
    private final HashMap<String, HashSet<Integer>> invertedIndexesMap;
    private final SearchContext searchContext;


    public DataBase(String file) {
        dataBase = new ArrayList<>();
        this.file=new File(file);
        invertedIndexesMap = new HashMap<>();
        searchContext=new SearchContext();
    }

    public void find(){
        HashSet<Integer> indexes = searchContext.search(invertedIndexesMap);
        if(indexes==null){
            System.out.println("No matching people found.");
        }else {
            for(int i : indexes){
                System.out.println(dataBase.get(i));
            }
        }
    }


    public void loadFile() {
        try(Scanner scanner = new Scanner(file)) {
            int index = 0;
            while (scanner.hasNextLine()){
                String input = scanner.nextLine();
                dataBase.add(input);
                String [] split = input.split(" ");
                for(String s : split){
                    indexIt(s,index);
                }
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printAll(){
        for (String s : dataBase){
            System.out.println(s);
        }
    }

    private void indexIt(String s, int index) {
        if (invertedIndexesMap.containsKey(s.toLowerCase())){
            invertedIndexesMap.get(s.toLowerCase()).add(index);
        }else {
            invertedIndexesMap.put(s.toLowerCase(),new HashSet<>(){{
                add(index);
            }});
        }
    }

    public void setSearchAlgorithm(String matching, ArrayList<String> query){

        switch (matching){
            case "ALL":
                searchContext.setSearchMethod(new SearchAll(query));
                break;
            case "ANY":
                searchContext.setSearchMethod(new SearchAny(query));
                break;
            case "NONE":
                searchContext.setSearchMethod(new SearchNone(query));
                break;
            default:
                throw new IllegalArgumentException("Wrong strategy");
        }
    }
}
