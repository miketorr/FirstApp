package empty.firstapp.model;

import java.util.ArrayList;

public class rText {
    private ArrayList<String> list = new ArrayList<String>();


    public rText() {

        for (int i = 0; i<10; i++) {
            list.add("Random Text "+i);
        }

    }


    public ArrayList<String> getList() {
        return list;
    }




}
