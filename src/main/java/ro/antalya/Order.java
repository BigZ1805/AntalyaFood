package ro.antalya;


public class Order {

  public Order (Product product) {
        Recipe recipe = new Recipe();
              switch (product) {
                  case SHAORMA_PUI_MICA:
                    System.out.println("Ati comandat o shaorma mica de pui!");
                      recipe.applyRecipe(Product.SHAORMA_PUI_MICA);
                      break;

                  case SHAORMA_PUI_MARE:
                  System.out.println("Ati comandat o shaorma mare de pui, cu ce sa fie?");
                      recipe.applyRecipe(Product.SHAORMA_PUI_MARE);
                      break;

                  case SHAORMA_VITA_MICA:
                  System.out.println("Ati comandat o shaorma mica de vita, cu ce sa fie?");
                      recipe.applyRecipe(Product.SHAORMA_VITA_MICA);
                      break;

                  case SHAORMA_VITA_MARE:
                      System.out.println("Ati comandat o shaorma mare de vita, cu ce sa fie?");
                      recipe.applyRecipe(Product.SHAORMA_VITA_MARE);
                      break;

                  case SHAORMA_MIX:
                 System.out.println("Ati comandat o shaorma mix, cu ce sa fie?");
                      recipe.applyRecipe(Product.SHAORMA_MIX);
                      break;

                  case KEBAB_PUI:
                      System.out.println("Ati comandat un kebab de pui, cu ce sa fie?");
                      recipe.applyRecipe(Product.KEBAB_PUI);
                      break;

                  case KEBAB_VITA:
                      System.out.println("Ati comandat kebab de vita, cu ce sa fie?");
                      recipe.applyRecipe(Product.KEBAB_VITA);
                      break;
              }

  }

}