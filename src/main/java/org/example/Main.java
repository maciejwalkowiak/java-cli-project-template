package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.example.picocli.PropertiesFileVersionProvider;
import picocli.CommandLine;

@CommandLine.Command(name = "app", mixinStandardHelpOptions = true, versionProvider = PropertiesFileVersionProvider.class)
public class Main implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "directory to search")
    private Path path;

    @Override public Integer call() throws Exception {
        WildcardFileFilter filter = new WildcardFileFilter("*.java");

        try (Stream<Path> stream = Files.walk(path)) {
            stream.filter(path -> filter.accept(path.toFile()))
                    .forEach(System.out::println);
            return 0;
        } catch (NoSuchFileException e) {
            System.err.println("specified directory does not exist");
        } catch (IOException e) {
            System.err.println("Ooops, an error happened " + e.getMessage());
        }
        return 1;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
