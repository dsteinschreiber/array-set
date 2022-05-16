package org.example;

public class PureIntegerHashSet extends MyAbstractSet<Integer> {

    MyList<Integer>[] buckets;

    public PureIntegerHashSet(int numberOfBuckets) {
        this.buckets = new MyList[numberOfBuckets];
    }

    private int hash(Integer value) {
        return value % this.buckets.length;
    }

    public static MyAbstractSet<Integer> of(int numberOfBuckets , Integer... values){
        MyAbstractSet<Integer> result = new PureIntegerHashSet(numberOfBuckets);

        for (Integer value : values) {
            result.add(value);
        }

        return result;
    }

    @Override
    public MyAbstractSet<Integer> add(Integer value) {
        int hashedValue = hash(value);
        if (this.buckets[hashedValue] == null){
            this.buckets[hashedValue] = new MyList<>();
        }

        this.buckets[hashedValue].append(value);

        // A clearer code:
//        if (this.buckets[hashedValue] != null){
//            this.buckets[hashedValue].append(value);
//        } else {
//            MyList<Integer> result = new MyList<>();
//            result.append(value);
//            this.buckets[hashedValue] = result;
//        }

        return this;
    }

    @Override
    public MyAbstractSet<Integer> remove(Integer integer) {
        return null;
    }

    @Override
    public boolean contains(Integer value) {
        int hashedValue = hash(value);

        if (this.buckets[hashedValue] == null){
            return false;
        } else {
            return this.buckets[hashedValue].contains(value);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        int sizeCounter = 0;

        return sizeCounter;
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
    public boolean isSubsetOf(MyAbstractSet<Integer> myAbstractSet) {
        return false;
    }
}
