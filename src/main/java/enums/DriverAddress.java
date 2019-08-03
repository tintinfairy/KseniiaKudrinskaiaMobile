package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriverAddress {
    PROTOCOL("http://"),
    APP_TYPE("EPM-TSTF:"),
    MOBILE_CLOUD("@mobilecloud.epam.com:8080/wd/hub");
    private String entity;
}
