package org.example;

public class IntegerHashSet extends GenericHashSet<Integer>{

    public IntegerHashSet(int numberOfBuckets) {
        super(numberOfBuckets);
    }

    public static GenericHashSet<Integer> of(int numberOfBuckets , Integer... values){
        GenericHashSet<Integer> result = new IntegerHashSet(numberOfBuckets);

        for (Integer value : values) {
            result.add(value);
        }

        return result;
    }

    @Override
    protected int hash(Integer value) {
        return value % this.buckets.length;
    }
}
