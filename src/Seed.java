public class Seed {
    long decalage;
    long min;
    long max;
    public Seed(long a, long b , long c){
        decalage = a-b;
        min = b;
        max = b+c-1;
    }

    public boolean contains(long origin){
        return (origin <= max && origin >=min);
    }

   

    @Override
    public String toString() {
        return "Seed [decalage=" + decalage + ", min=" + min + ", max=" + max + "]";
    }

    public long getDecalage() {
        return decalage;
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
    
    
}
