package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactNames {
    USER_1("Tom"),
    USER_2("Jessy"),
    USER_3("Sue");
    private String name;
}
