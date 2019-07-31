package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Platforms {

    ANDROID("Android"),
    IOS("iOS");
    private String platformName;
}
