import app.CommandlineFileProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileBotApp {

    public static void main(String[] args) {
        log.info(System.getProperty("user.dir"));
        CommandlineFileProcessor.process(args);
    }

}
