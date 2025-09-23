package com.phong.leetcode.base;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
public abstract class AbstractBaseClass<T> {

    protected abstract T run();

    public T runWithLog() {
        return runWithLog(true, true);
    }

    public T runWithLog(boolean logTime, boolean logMemory) {
        long memoryBefore = 0;
        long startTime = 0;
        if (logTime) {
            startTime = System.currentTimeMillis();
        }
        if (logMemory) {
            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        }
        T result = run();
        System.out.println("[" + this.getClass().getSimpleName() + "] Result: " + result);
        if (logTime) {
            long endTime = System.currentTimeMillis();
            System.out.println("[" + this.getClass().getSimpleName() + "] Total time: " + (endTime - startTime) + " ms");
        }
        if (logMemory) {
            Runtime runtime = Runtime.getRuntime();
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("[" + this.getClass().getSimpleName() + "] Memory used: " + (memoryAfter - memoryBefore) / 1024 + " KB");
        }
        return result;
    }
}
