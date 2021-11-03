package dto.script;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ScriptsDto {
    private List<ScriptDto> scripts;
}
