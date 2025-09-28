package com.phong.leetcode.problem.medium;

import com.phong.leetcode.base.AbstractBaseClass;
import org.springframework.stereotype.Service;

import java.util.concurrent.Semaphore;

@Service
public class PrintFooBarAlternately extends AbstractBaseClass<Void> {
    @Override
    protected Void run() {
        return null;
    }

    public static class FooBar {
        private final int n;
        private final Semaphore fooSem = new Semaphore(1);
        private final Semaphore barSem = new Semaphore(0);
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSem.acquire();
                printFoo.run();
                barSem.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSem.acquire();
                printBar.run();
                fooSem.release();
            }
        }
    }
}
