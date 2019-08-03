package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataToSetProperties {
    SITE_PROTOCOL("https://");
    private String element;
}
