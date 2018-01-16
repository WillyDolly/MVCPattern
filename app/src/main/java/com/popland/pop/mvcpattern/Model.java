package com.popland.pop.mvcpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by hai on 15/01/2018.
 */

public class Model extends Observable{
    private List<Integer> numberList;

    public Model(){
        numberList = new ArrayList<>(3);
        numberList.add(0);
        numberList.add(0);
        numberList.add(0);
    }

    public int getValueAtIndex(int index) throws IndexOutOfBoundsException{
        return numberList.get(index);
    }

    public void setValueAtIndex(int index) throws IndexOutOfBoundsException{
        numberList.set(index,numberList.get(index)+1);
        setChanged();
        notifyObservers();// call method update() in Observer
    }
}
