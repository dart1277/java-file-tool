package domain.script;

import domain.file.FileInfo;
import domain.port.FileInfoReaderPort;
import domain.script.action.Action;
import domain.script.matcher.MatcherRule;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class Script {
    private final Action action;
    private List<MatcherRule> rules = new ArrayList<>();

    public void addRule(MatcherRule rule) {
        rules.add(rule);
    }

    public void execute(FileInfoReaderPort fileInfoReaderPort) {
        // file infos should be read before every script to get correct state after modifications
        List<FileInfo> fileInfos = fileInfoReaderPort.read();
        fileInfos.stream()
                .filter(allRulesMatchPredicate())
                .forEach(action::perform);

    }

    private Predicate<FileInfo> allRulesMatchPredicate() {
        return fileInfo -> rules.stream().allMatch(rule -> rule.test(fileInfo));
    }
}
