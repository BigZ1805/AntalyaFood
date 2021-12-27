package ro.antalya;


import java.util.*;

public class Recipe {

    List<String> values = Ingredients.getValues();

    public void getRecipe(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sa fie cu de toate? DA / NU");
        boolean DeToate = scanner.nextBoolean();
        if (DeToate) {
            System.out.println("OK! Cu de toate!");
            System.out.println("O facem iute? DA/NU");
            boolean Iute = scanner.nextBoolean();
            if (Iute) {
                values.remove("KETCHUP_DULCE");
                System.out.println("Deci cu de toate si iute! Am inteles!");
            }
            else {
                values.remove("SOS_IUTE");
                System.out.println("Deci cu de toate si dulce! Am inteles!");
            }
        }
        else
        {
            System.out.println("OK! Deci o facem custom! Hai sa vedem! Sa fie iute? DA/NU");
            boolean Iute = scanner.nextBoolean();
            if (Iute) {
                values.remove("KETCHUP_DULCE");
                System.out.println("Bun, iute ca focul! In rest mai scoatem ceva? Ce scoatem?");
                String Scoatem = scanner.next();
                values.remove(Scoatem);
                System.out.println("OK, fara " + Scoatem);
            }
            else {
                values.remove("SOS_IUTE");
                System.out.println("OK, deci dulce! In rest mai scoatem ceva? Ce scoatem?");
                String Scoatem = scanner.next();
                values.remove(Scoatem);
                System.out.println("OK, fara " + Scoatem);
            }
            System.out.println("Mai scoatem ceva? DA/NU");
            boolean MaiScoatem = scanner.nextBoolean();
            while (MaiScoatem) {
                System.out.println("Ce mai scoatem?");
                String Scoatem = scanner.next();
                values.remove(Scoatem);
                System.out.println("OK, am scos si " + Scoatem);
                System.out.println("Mai scoatem ceva? DA/NU");
                MaiScoatem = scanner.nextBoolean();
            }

        }
    }


    public void applyRecipe(Product product) {
        switch (product) {
        case SHAORMA_PUI_MICA:
            getRecipe(Product.SHAORMA_PUI_MICA);
            values.remove("CARNE_VITA");
            values.remove("CARNE_PORC");
            values.remove("CHIFLE");
            System.out.println("OK! Atunci ramane sa punem " + values);
        break;
        case SHAORMA_PUI_MARE:
            getRecipe(Product.SHAORMA_PUI_MARE);
            values.remove("CARNE_VITA");
            values.remove("CARNE_PORC");
            values.remove("CHIFLE");
            System.out.println("OK! Atunci ramane sa punem " + values);
            break;
        case SHAORMA_VITA_MICA:
            getRecipe(Product.SHAORMA_VITA_MICA);
            values.remove("CARNE_PUI");
            values.remove("CARNE_PORC");
            values.remove("CHIFLE");
            System.out.println("OK! Atunci ramane sa punem " + values);
            break;
        case SHAORMA_VITA_MARE:
            getRecipe(Product.SHAORMA_VITA_MARE);
            values.remove("CARNE_PUI");
            values.remove("CARNE_PORC");
            values.remove("CHIFLE");
            System.out.println("OK! Atunci ramane sa punem " + values);
            break;
        case SHAORMA_MIX:
            getRecipe(Product.SHAORMA_MIX);
            values.remove("CHIFLE");
            System.out.println("OK! Atunci ramane sa punem " + values);
            break;
        case KEBAB_PUI:
            getRecipe(Product.KEBAB_PUI);
            values.remove("CARNE_VITA");
            values.remove("CARNE_PORC");
            values.remove("LIPIE");
            System.out.println("OK! Atunci ramane sa punem " + values);

            break;
        case KEBAB_VITA:
            getRecipe(Product.KEBAB_VITA);
            values.remove("CARNE_PUI");
            values.remove("CARNE_PORC");
            values.remove("LIPIE");
            System.out.println("OK! Atunci ramane sa punem " + values);
            break;
    }
    }

}


