package com.erick.company.jvm.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {

    public static void main(String[] args) {
        List<byte[]> memoryHog = new ArrayList<>();

        while (true) {
            memoryHog.add(new byte[1024 * 1024]); // 1MB chunks
            System.out.println("Allocated 1MB - Total: " + memoryHog.size() + " MB");
        }
    }
}
