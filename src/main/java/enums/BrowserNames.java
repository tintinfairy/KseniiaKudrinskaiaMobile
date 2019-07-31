package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BrowserNames {
    CHROME("Chrome"),
    SAFARI("Safari");
    private String browserName;
}

