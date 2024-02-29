package org.example.Program;

public class Count implements AutoCloseable {
    private int count;

    public Count() {
        this.count = 0;
    }
    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close(){
        if (count > 0) {
            throw new IllegalStateException("Ресурс остался открыт");
        }
    }
}
