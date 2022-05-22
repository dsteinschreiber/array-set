package org.example;


import java.util.Iterator;

public class ArraySet extends MyAbstractSet<Integer> {

    boolean[] switches;

    public ArraySet(int length){
        this.switches = new boolean[length];
    }

    public static MyAbstractSet<Integer> of(int length, int... values) {
        ArraySet result = new ArraySet(length);

        for (int value : values) {
            result.add(value);
        }

        return result;
    }

    @Override
    public MyAbstractSet<Integer> add(Integer value) {
        this.switches[value] = true;
        return this;
    }

    @Override
    public MyAbstractSet<Integer> remove(Integer value) {
        this.switches[value] = false;
        return this;
    }

    @Override
    public boolean contains(Integer value) {
        return this.switches[value];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        int result = 0;

       // for (int i = 0; i < this.switches.length; i++){


        for (boolean aSwitch : this.switches) {
            if (aSwitch) {
                result++;
            }
        }

        return result;
    }

    @Override
    public MyList<Integer> toList() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
