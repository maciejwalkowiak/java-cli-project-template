package org.example;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

class MainTests {
    private Main app = new Main();
    private CommandLine cmd = new CommandLine(app);
    private StringWriter sw = new StringWriter();

    @BeforeEach
    void init() {
        cmd.setOut(new PrintWriter(sw));
    }

    @Test
    void printsVersion() {
        int exitCode = cmd.execute("-V");
        assertThat(exitCode).isEqualTo(0);
        assertThat(sw.toString()).isNotBlank().doesNotContain("file found");
    }

}
