package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactNames {
    USER_1("Tomas"),
    USER_2("Jessica"),
    USER_3("Susanna");
    private String name;
}