package pol.prashant.sample.viewmodelsample.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by prashant.pol on 12/25/2017.
 */

public class DataProvider {

    private static DataProvider instance;
    private HashMap<String, String> data = new HashMap<>();

    private DataProvider(){
        for (int i = 1; i <= 100; i++) {
            data.put("Title " + i, "This is Text to show data of " + i);
        }
    }

    public static DataProvider getInstance() {
        if(instance == null) {
            instance = new DataProvider();
        }

        return instance;
    }

    public HashMap<String, String> getData(){
        return data;
    }
}
