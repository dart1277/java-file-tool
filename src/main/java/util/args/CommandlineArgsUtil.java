package util.args;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This simple util class is created under assumption that command line arguments don't change frequently
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommandlineArgsUtil {

    private static final Options options = new Options();

    static {
        Arrays.stream(CommandlineArg.values())
                .forEach(arg -> options.addOption(buildOption(arg)));
    }

    public static Map<CommandlineArg, String> parseArgs(String[] args) throws ParseException {
        DefaultParser parser = new DefaultParser();
        CommandLine parse = parser.parse(options, args);
        return options.getOptions().stream()
                .filter(parse::hasOption)
                .collect(Collectors.toMap(option -> CommandlineArg.parse(option.getLongOpt()),
                        option -> parse.getOptionValue(option.getLongOpt())));
    }


    private static Option buildOption(CommandlineArg arg) {
        return Option.builder()
                .option(arg.option)
                .longOpt(arg.longOption)
                .desc(arg.description)
                .hasArg()
                .required(arg.required)
                .valueSeparator(' ')
                .build();
    }

    @AllArgsConstructor
    public enum CommandlineArg {

        DIR("d", "dir", "working directory", true),
        SCRIPTS("s", "scripts", "scripts json file", true);

        private final String option;
        private final String longOption;
        private final String description;
        private final boolean required;

        public static CommandlineArg parse(String argString) { // argString is not null and parseable to CommandlineArg
            return valueOf(argString.toUpperCase(Locale.ROOT));
        }

    }
}
