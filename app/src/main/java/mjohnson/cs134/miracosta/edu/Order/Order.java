package mjohnson.cs134.miracosta.edu.Order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static final double CA_SALES_TAX = 0.08;

    /** All enclosed classes at bottom */
    private List<DoubleDouble> doubleDouble;
    private static final double doubleDoublePrice = 3.60;
    private List<CheeseBurger> cheeseBurger;
    private static final double cheeseBurgerPrice = 2.15;
    private List<FrenchFries> frenchFries;
    private static final double frenchFriesPrice = 1.65;
    private List<Shake> shake;
    private static final double shakePrice = 2.20;
    /** Let's keep the fountain drinks simple */
    private int smallDrinks;
    private static final double smallDrinkPrice = 1.45;
    private int mediumDrinks;
    private static final double mediumDrinkPrice = 1.55;
    private int largeDrinks;
    private static final double largeDrinkPrice = 1.75;



    /** Secret menu items below */
    // add these to the cost
    private static final double animalStyleBurgerPrice = .50;
    private static final double animalStyleFriesPrice = .30;
    private static final double largeShakeFee = .60;
    // its a So-Cal restaurant. Don't need to worry about foreign money (for the next 100 years at least right?)
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private double subTotal;
    private double tax;
    private double total;

    /** lists the size of the array lists */
    private int doubleDoubleQuant;
    private int cheeseburgerQuant;
    private int fryQuant;
    private int shakeQuant;



    /** constructor */
    public Order () {

        doubleDouble = new ArrayList<>();
        cheeseBurger = new ArrayList<>();
        frenchFries = new ArrayList<>();
        shake = new ArrayList<>();

        subTotal=0;
        tax = 0;
        total=0;

        smallDrinks=0;
        mediumDrinks=0;
        largeDrinks=0;

        doubleDoubleQuant=0;
        cheeseburgerQuant=0;
        fryQuant=0;
        shakeQuant=0;
    }







        /** getters */

    public static double getCaSalesTax() {
        return CA_SALES_TAX;
    }

    public static double getDoubleDoublePrice() {
        return doubleDoublePrice;
    }

    public static double getCheeseBurgerPrice() {
        return cheeseBurgerPrice;
    }

    public static double getFrenchFriesPrice() {
        return frenchFriesPrice;
    }

    public static double getShakePrice() {
        return shakePrice;
    }

    public static double getSmallDrinkPrice() {
        return smallDrinkPrice;
    }

    public static double getMediumDrinkPrice() {
        return mediumDrinkPrice;
    }

    public static double getLargeDrinkPrice() {
        return largeDrinkPrice;
    }

    public int getDoubleDoubleQuant() {
        return doubleDoubleQuant;
    }

    public int getCheeseburgerQuant() {
        return cheeseburgerQuant;
    }

    public int getFryQuant() {
        return fryQuant;
    }

    public int getShakeQuant() {
        return shakeQuant;
    }

    public int getSmallDrinks() {
        return smallDrinks;
    }

    public int getMediumDrinks() {
        return mediumDrinks;
    }

    public int getLargeDrinks() {
        return largeDrinks;
    }

    public DoubleDouble getDoubleDouble(int i) {return doubleDouble.get(i);}

    public CheeseBurger getCheeseburger(int i) { return cheeseBurger.get(i); }

    public FrenchFries getFrenchFries(int i) { return frenchFries.get(i); }

    public Shake getShake(int i) { return shake.get(i); }

    public static double getAnimalStyleBurgerPrice() {
        return animalStyleBurgerPrice;
    }

    public static double getAnimalStyleFriesPrice() {
        return animalStyleFriesPrice;
    }

    public static double getLargeShakeFee() {
        return largeShakeFee;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }



        /** adds to the respective array lists */
    public void addDoubleDouble() {doubleDouble.add(new DoubleDouble()); doubleDoubleQuant++;}
    public void addCheeseburger() {cheeseBurger.add(new CheeseBurger()); cheeseburgerQuant++;}
    public void addFrenchFries() {frenchFries.add( new FrenchFries()); fryQuant++;}
    public void addShake() {shake.add(new Shake()); shakeQuant++;}

        /** removes from the respoective array lists */
    public void removeDoubleDouble(int i) {
        if (!doubleDouble.isEmpty())
            doubleDouble.remove(i);
        if (doubleDoubleQuant>0)
            doubleDoubleQuant--;}
    public void removeCheeseburger(int i) {
        if (!cheeseBurger.isEmpty())
            cheeseBurger.remove(i);
        if (cheeseburgerQuant>0)
            cheeseburgerQuant--;}
    public void removeFrenchFries(int i) {
        if (!frenchFries.isEmpty())
            frenchFries.remove(i);
        if (fryQuant>0)
            fryQuant--;
    }
    public void removeShake(int i) {
        if (!shake.isEmpty())
            shake.remove(i);
        if (shakeQuant>0)
            shakeQuant--;
    }

    // pass this the shake position and the flavor (1: vanilla, 2: chocolate, 3: strawberry)
    public void setShakeFlavor(int i, int f) {shake.get(i).setFlavor(f);}
    // pass this the object type (DoubleDouble, Cheeseburger, FrenchFries) and the position of it
    public void setAnimalStyle(Object o, int i) {
        if (o instanceof DoubleDouble)
            doubleDouble.get(i).setAnimalStyle();
        else if(o instanceof CheeseBurger)
            cheeseBurger.get(i).setAnimalStyle();
        else if (o instanceof FrenchFries)
            frenchFries.get(i).setAnimalStyle();
        else
            System.out.println("Wrong object type passed to 'setAnimalStyle(Object o, int i)'");
        // this could only be a programmer's fault so we'll exit app if they fucked up and forgot to test their shit
            System.exit(0);
    }

        /** adds/removes to/from the simple int counts of drinks */
    public void addSmallDrink() {smallDrinks++;}
    public void addMediumDrink() {mediumDrinks++;}
    public void addLargeDrink() {largeDrinks++;}
    public void removeSmallDrink() { if (smallDrinks>0) smallDrinks--; }
    public void removeMediumDrink() { if (mediumDrinks>0) mediumDrinks--;}
    public void removeLargeDrink() { if (largeDrinks>0) largeDrinks--;}


    /** toString() will also calculate subtotal, tax, and total. Call it if needed without printing it anywhere
     * -> Yes I know this isn't efficient but I am damn well not going to rewrite this */
    @Override
    public String toString() {

        String s = "OrderActivity: ";

        // add double doubles to order print
        for (int i=0; i < doubleDouble.size(); i++) {

            /** first get the burger details */
            s+="\n" + doubleDouble.get(i).toString();
            // now moving to price, if its animal style, show the original cost + the add fee
            if (doubleDouble.get(i).getAnimalStyle()) {
                subTotal+=doubleDoublePrice+animalStyleBurgerPrice;
                s += "\n\t\t$" + df.format(doubleDoublePrice + animalStyleBurgerPrice);
            }
            // otherwise show the original price
            else {
                subTotal+=doubleDoublePrice;
                s += "\n\t\t$" + df.format(doubleDoublePrice);
            }
        }

        /** add cheeseburgers to order print */
        for (int i=0; i < cheeseBurger.size(); i++) {

            s+="\n" + cheeseBurger.get(i).toString();
            // now moving to price, if its animal style, show the original cost + the add fee
            if (cheeseBurger.get(i).isAnimalStyle) {
                subTotal+= cheeseBurgerPrice+animalStyleBurgerPrice;
                s += "\n\t\t$" + df.format(cheeseBurgerPrice + animalStyleBurgerPrice);
            }
                // otherwise show the original price
            else {
                subTotal+=cheeseBurgerPrice;
                s += "\n\t\t$" + df.format(cheeseBurgerPrice);
            }
        }

        /** add french fries to order print */
        for (int i=0; i < frenchFries.size(); i++) {

            s+="\n" + frenchFries.get(i).toString();
            // now moving to price, if its animal style, show the original cost + the add fee
            if (frenchFries.get(i).isAnimalStyle) {
                subTotal+=frenchFriesPrice+animalStyleFriesPrice;
                s += "\n\t\t$" + df.format(frenchFriesPrice + animalStyleFriesPrice);
            }
                // otherwise show the original price
            else {
                subTotal+=frenchFriesPrice;
                s += "\n\t\t$" + df.format(frenchFriesPrice);
            }
        }

        /** add shakes to order print */
        for (int i=0; i < shake.size(); i++) {

            s+="\n" + shake.get(i).toString();
            if (shake.get(i).isLarge) {
                subTotal+= shakePrice+largeShakeFee;
                s += "\n\t\t$" + df.format(shakePrice + largeShakeFee);
            }
            else {
                subTotal+=shakePrice;
                s += "\n\t\t$" + df.format(shakePrice);
            }
        }

        /** add small, medium and large drinks to order */
        if (smallDrinks>0) {
            subTotal+=smallDrinks*smallDrinkPrice;
            s+= "\n" + smallDrinks + " Sm Ftn Drink";
            s+= "\n\t\t$" + df.format(smallDrinkPrice*smallDrinks);
        }

        if (mediumDrinks>0) {
            subTotal+=mediumDrinks*mediumDrinkPrice;
            s+= "\n" + mediumDrinks + " Med Ftn Drink";
            s+= "\n\t\t$" + df.format(mediumDrinkPrice*mediumDrinks);
        }

        if (largeDrinks>0) {
            subTotal+=largeDrinks*largeDrinkPrice;
            s+= "\n" + largeDrinks + " Lg Ftn Drink";
            s+= "\n\t\t$" + df.format(largeDrinkPrice*largeDrinks);
        }


        /** add total numbers and tax to print */

        s+="\n\n\t\t\tSubtotal:\t\t$" + df.format(subTotal);

        tax = subTotal*CA_SALES_TAX;
        s+="\n\n\t\t\tSales Tax (8%):\t$" + df.format(tax);

        total = tax + subTotal;
        s+="\n\n\t\t\tTotal:\t\t$" + df.format((total));




        return s;
    }





















    /** These all can be animalStyled */
    public static class DoubleDouble {
        private boolean AnimalStyle;

        public DoubleDouble() {
            AnimalStyle =false;
        }

        public boolean getAnimalStyle() {
            return AnimalStyle;
        }

        public void setAnimalStyle() { AnimalStyle = !AnimalStyle; }

        @Override
        public String toString() {
            String s = "Double Double";
            if (AnimalStyle)
                s+="\n\tAnimalStyle";
            return s;
        }

    }
    private class CheeseBurger {
        boolean isAnimalStyle = false;

        public void setAnimalStyle() { isAnimalStyle = !isAnimalStyle; }

        @Override
        public String toString() {
            String s = "Cheeseburger";
            if (isAnimalStyle)
                s+="\n\tAnimalStyle";
            return s;
        }
    }
    private class FrenchFries {
        boolean isAnimalStyle = false;

        public void setAnimalStyle() { isAnimalStyle = !isAnimalStyle; }

        @Override
        public String toString() {
            String s = "FF";
            if (isAnimalStyle)
                s+="\n\tAnimalStyle";
            return s;
        }
    }

    /** Basically if ordering off the normal menu, you'll get to choose one flavor.
     * If you order off the secret menu, you'll get to mix */
    private class Shake {

        // vanilla by default
        boolean [] flavor = {/*vanilla */true, /*chocolate*/false, /*strawberry*/false};
        boolean isLarge = false;

        // basic menu function
        public void setFlavor(int f) {
            switch (f) {
                case 1: // vanilla
                    flavor[0] = true;
                    flavor[1] = false;
                    flavor[2] = false;
                    break;
                case 2: // chocolate
                    flavor[0] = false;
                    flavor[1] = true;
                    flavor[2] = false;
                    break;
                case 3:
                    flavor[0] = false;
                    flavor[1] = false;
                    flavor[2] = false;
                    break;
                default:
                    System.out.println("Error in setting flavor. Check OrderActivity.java -> class Shake -> setFlavor(int f)\n" +
                                            "argument should be between 1 and 3. 1: Vanilla... 2: Chocolate... 3: Strawberry");
                    break;
            }
        }

        // secret menu functions
        public void addFlavor(int f) {
            if (f < 1 || f > 3) { System.out.println("Called with invalid argument. Should be between 1-3"); return; }
            flavor[f] = true;
        }
        public void removeFlavor(int f) {
            if (f < 1 || f > 3) { System.out.println("Called with invalid argument. Should be between 1-3"); return; }
            flavor[f] = false;
        }
        public void changeSize()  { isLarge = !isLarge; }

        @Override
        public String toString() {
            String s = "Shake";
            if (isLarge) s = "Lg Shake";

            if (flavor[0])
                s+="\n\tVanilla";
            if (flavor[1])
                s+="\n\tChocolate";
            if (flavor[2])
                s+="\n\tStrawberry";


            return s;
        }
    }



}
