package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class GenericHashSet<T> extends MyAbstractSet<T> {

    MyList<T>[] buckets;

    @SuppressWarnings("unchecked")
    public GenericHashSet(int numberOfBuckets) {
        this.buckets = new MyList[numberOfBuckets];
    }

    @SafeVarargs
    public static <T> GenericHashSet<T> asOfSize(int buckets, T... values){
        GenericHashSet<T> result = new GenericHashSet<>(buckets);

        for (T value : values){
            result.add(value);
        }

        return result;
    }

    @SafeVarargs
    // method "of" has default bucket size of 1000
    public static <T> GenericHashSet<T> of(T... values) {
        return asOfSize(1000, values);
    }


    protected int hash(T value) {
        return value.hashCode() % this.buckets.length;
    }


    @Override
    public MySet<T> add(T value) {
        int hashedValue = this.hash(value);
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
        int hashedValue = this.hash(value);

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

    // Not most performant way, but functional
    @Override
    public Iterator<T> iterator() {
        return this.toList().iterator();
    }
}
