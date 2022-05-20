package org.example;

import java.util.Arrays;
import java.util.Iterator;

public abstract class GenericHashSet<T> extends MyAbstractSet<T> {

    MyList<T>[] buckets;


    @SuppressWarnings("unchecked")
    public GenericHashSet(int numberOfBuckets) {
        this.buckets = new MyList[numberOfBuckets];
    }

    /// HASH
    abstract protected int hash(T value);

    @Override
    public MySet<T> add(T value) {
        int hashedValue = hash(value);
        if (this.buckets[hashedValue] == null) {
            this.buckets[hashedValue] = new MyList<>();
        }

        if (!this.buckets[hashedValue].contains(value)) {
            this.buckets[hashedValue].append(value);
        }

        return this;
    }

    @Override
    public MySet<T> remove(T value) {
        for (MyList<T> bucket : this.buckets) {
            if (bucket != null) {
                Iterator<T> it = bucket.iterator();

                while (it.hasNext()) {
                    T v = it.next();

                    if (v.equals(value)) {
                        it.remove();
                    }
                }
            }
        }
        return this;
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
    public MyList<T> toList() {
        MyList<T> result = new MyList<>();

        for (MyList<T> bucket : this.buckets) {
            if (bucket != null) {
                for (T value : bucket) {
                    result.append(value);
                }
            }
        }

        return result;
    }
}
