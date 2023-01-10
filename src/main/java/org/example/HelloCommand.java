package org.example;

import java.util.concurrent.Callable;

import picocli.CommandLine;

@CommandLine.Command(name = "hello")
public class HelloCommand implements Callable<Integer> {

    @CommandLine.Option(names = "--name", defaultValue = "World")
    private String name;

    @Override public Integer call() {
        System.out.printf("Hello %s!%n", name);
        return 0;
    }
}
