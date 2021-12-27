package ro.antalya;

import java.util.*;

public enum  Ingredients {
    CARNE_PUI("CARNE_PUI"),
    CARNE_VITA("CARNE_VITA"),
    CARNE_PORC("CARNE_PORC"),
    LIPIE("LIPIE"),
    CHIFLE("CHIFLE"),
    SOS_USTUROI("SOS_USTUROI"),
    SOS_TZATZIKI("SOS_TZATZIKI"),
    CARTOFI_PRAJITI("CARTOFI_PRAJITI"),
    CEAPA("CEAPA"),
    ROSII("ROSII"),
    CASTRAVETI_MURATI("CASTRAVETI_MURATI"),
    SALATA_VARZA("SALATA_VARZA"),
    SOS_IUTE("SOS_IUTE"),
    KETCHUP_DULCE("KETCHUP_DULCE");

    private static final List<String> VALUES;

    private final String value;

    static {
        VALUES = new ArrayList<>();
        for (Ingredients ingredients : Ingredients.values()) {
            VALUES.add(ingredients.value);
        }
    }

    Ingredients(String value) {
        this.value = value;
    }

    public static List<String> getValues() {
        return VALUES;
    }

    }

