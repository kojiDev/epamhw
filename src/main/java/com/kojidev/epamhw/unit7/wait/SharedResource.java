package com.kojidev.epamhw.unit7.wait;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private List<Integer> list = new ArrayList<>();

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }

        return null;
    }
}
