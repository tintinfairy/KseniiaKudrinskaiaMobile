package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataToSetProperties {
    PROTOCOL("https://"),
    APP_SOURCE("src/main/resources/");
    private String element;
}
