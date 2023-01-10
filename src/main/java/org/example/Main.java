package org.example;

import org.example.picocli.PropertiesFileVersionProvider;
import picocli.CommandLine;

@CommandLine.Command(name = "app", mixinStandardHelpOptions = true, versionProvider = PropertiesFileVersionProvider.class, subcommands = {
        HelloCommand.class, ListFilesCommand.class })
public class Main {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
