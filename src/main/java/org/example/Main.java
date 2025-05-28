package org.example;

import org.apache.fury.Fury;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fury fury = Fury.builder().withCodegen(false).build();
        fury.register(NumberListRecord.class);
        fury.register(IntArrayList.class);
        byte[] bytes = fury.serialize(new NumberListRecord(1L, new ArrayList<>()));
        fury.deserialize(bytes);
    }

    static class IntArrayList extends ArrayList<Integer> {}

    record NumberListRecord(Number n, List<Object> list) {
    }
}
