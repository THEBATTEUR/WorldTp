package fr.thebatteur.worldtp;

import java.util.Arrays;

public enum Language {

    FR("fr"),
    EN("en");

    private String name;

    Language(String name) {
        this.name = name;
    }

    public static Language getByName(String name) {
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(Language.EN);
    }

    public String getName() {
        return name;
    }
}
