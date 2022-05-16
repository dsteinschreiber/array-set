package org.example;

import java.util.Arrays;

public abstract class GenericHashSet<T> extends MyAbstractSet<T> {

    MyList<T>[] buckets;

    public GenericHashSet(int numberOfBuckets) {
        this.buckets = new MyList[numberOfBuckets];
    }

    /// HASH
    abstract protected int hash(T value);

    @Override
    public MyAbstractSet<T> add(T value) {
        int hashedValue = hash(value);
        if (this.buckets[hashedValue] == null) {
            this.buckets[hashedValue] = new MyList<>();
        }

        this.buckets[hashedValue].append(value);

        return this;
    }

    @Override
    public MyAbstractSet<T> remove(T t) {
        return null;
    }

    @Override
    public boolean contains(T value) {
        int hashedValue = hash(value);

        if (this.buckets[hashedValue] == null) {
            return false;
        } else {
            return this.buckets[hashedValue].contains(value);
        }
    }

    @Override
    public boolean isEmpty() {

//        for (MyList<T> bucket : this.buckets) {
//            if (bucket != null && !bucket.isEmpty()) {
//                return false;
//            }
//        }
//
//        return true;

        return Arrays.stream(this.buckets).allMatch(bucket -> bucket == null || bucket.isEmpty());
    }

    @Override
    public int size() {
        int result = 0;

        for (MyList<T> bucket : this.buckets) {
            if (bucket != null) {
                result += bucket.size();
            }
        }

        return result;
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
    public boolean isSubsetOf(MyAbstractSet<T> myAbstractSet) {
        return false;
    }
}
