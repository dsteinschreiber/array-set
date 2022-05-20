package org.example;

public class StringHashSet extends GenericHashSet<String> {

    public StringHashSet(int numberOfBuckets) {
        super(numberOfBuckets);
    }

    public static GenericHashSet<String> of(int numberOfBuckets , String... values){
        GenericHashSet<String> result = new StringHashSet(numberOfBuckets);

        for (String value : values) {
            result.add(value);
        }

        return result;
    }

    @Override
    protected int hash(String value) {
        int result = 0;

        for (char c : value.toCharArray()){
            result += c;
        }

        return result;
    }



}
