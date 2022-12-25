package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("directory to search not set");
            return;
        }

        WildcardFileFilter filter = new WildcardFileFilter("*.java");

        try (Stream<Path> stream = Files.walk(Paths.get(args[0]))) {
            stream.filter(path -> filter.accept(path.toFile()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
