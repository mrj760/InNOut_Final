package mjohnson.cs134.miracosta.edu.Order;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order implements Parcelable {

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
    private int totalItems;




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
        totalItems=0;
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

    public String drinksToString() {

        String s = "";

        if (getSmallDrinks()>0)
        {
            s+= getSmallDrinks() + " Sm Ftn Drink" +
                "\n\t\t\t\t\t\t$" + df.format(getSmallDrinks()*smallDrinkPrice);
        }
        if (getSmallDrinks()>0 && getMediumDrinks()>0)
            s+="\n";
        if (getMediumDrinks()>0)
        {
            s+= getMediumDrinks() + " Med Ftn Drink" +
                    "\n\t\t\t\t\t\t$" + df.format(getMediumDrinks()*mediumDrinkPrice);
        }
        if (getMediumDrinks()>0 && getLargeDrinks()>0)
            s+="\n";
        if (getSmallDrinks()>0 && getLargeDrinks()>0)
            s+="\n";
        if (getLargeDrinks()>0)
        {
            s+= getLargeDrinks() + " Lg Ftn Drink" +
                    "\n\t\t\t\t\t\t$" + df.format(getLargeDrinks()*largeDrinkPrice);
        }

        return s;
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

    public int getTotalItems() {
        return totalItems;
    }

    /** adds to the respective array lists */
    public void addDoubleDouble() {doubleDouble.add(new DoubleDouble()); doubleDoubleQuant++; totalItems++;}
    public void addCheeseburger() {cheeseBurger.add(new CheeseBurger()); cheeseburgerQuant++; totalItems++;}
    public void addFrenchFries() {frenchFries.add( new FrenchFries()); fryQuant++; totalItems++;}
    public void addShake() {
        shake.add(new Shake());
        shakeQuant++;
        totalItems++;
    }
    public void addShake(int f) {
        shake.add(new Shake(f));
        shakeQuant++;
        totalItems++;
    }

        /** removes from the respective array lists */
    public void removeDoubleDouble(int i) {
        if (!doubleDouble.isEmpty()) {
            doubleDouble.remove(i);
            doubleDoubleQuant--;
            totalItems--;
        }
    }
    public void removeCheeseburger(int i) {
        if (!cheeseBurger.isEmpty()) {
            cheeseBurger.remove(i);
            cheeseburgerQuant--;
            totalItems--;
        }
    }
    public void removeFrenchFries(int i) {
        if (!frenchFries.isEmpty()) {
            frenchFries.remove(i);
            fryQuant--;
            totalItems--;
        }
    }
    public void removeShake(int i) {
        if (!shake.isEmpty()) {
            shake.remove(i);
            shakeQuant--;
            totalItems--;
        }
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

        /** Have to make these 0 at the beginning here because otherwise as the object gets passed back and forth the total prices
         * basically double every time since we're just adding themselves ,+/- whatever extra costs, to their previous values */
        subTotal =0;
        tax = 0;
        total = 0;

        String s = "Your Order: \n";

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

        s+="\n\n\n\t\t\tSubtotal:\t\t\t\t$" + df.format(subTotal);

        tax = subTotal*CA_SALES_TAX;
        s+="\n\n\t\t\tSales Tax (8%):\t$" + df.format(tax);

        total = tax + subTotal;
        s+="\n\n\t\t\tTotal:\t\t\t\t\t$" + df.format((total));




        return s;
    }





















    /** These all can be animalStyled */
    public static class DoubleDouble implements Parcelable {
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
            double price = getDoubleDoublePrice();
            String s = "Double Double";
            if (AnimalStyle) {
                s += "\n\tAnimal Style";
                price = getDoubleDoublePrice()+animalStyleBurgerPrice;
            }
            s+="\n\t\t\t\t\t\t$" + df.format(price);
            return s;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.AnimalStyle ? (byte) 1 : (byte) 0);
        }

        protected DoubleDouble(Parcel in) {
            this.AnimalStyle = in.readByte() != 0;
        }

        public static final Parcelable.Creator<DoubleDouble> CREATOR = new Parcelable.Creator<DoubleDouble>() {
            @Override
            public DoubleDouble createFromParcel(Parcel source) {
                return new DoubleDouble(source);
            }

            @Override
            public DoubleDouble[] newArray(int size) {
                return new DoubleDouble[size];
            }
        };
    }
    public static class CheeseBurger implements Parcelable {


        boolean isAnimalStyle = false;

        public boolean getAnimalStyle() {
            return isAnimalStyle;
        }

        public void setAnimalStyle() { isAnimalStyle = !isAnimalStyle; }

        @Override
        public String toString() {
            String s = "Cheeseburger";
            double price = getCheeseBurgerPrice();
            if (isAnimalStyle) {
                s += "\n\tAnimal Style";
                price = getCheeseBurgerPrice()+animalStyleBurgerPrice;
            }

            s+="\n\t\t\t\t\t\t$" + df.format(price);
            return s;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isAnimalStyle ? (byte) 1 : (byte) 0);
        }

        public CheeseBurger() {
        }

        protected CheeseBurger(Parcel in) {
            this.isAnimalStyle = in.readByte() != 0;
        }

        public static final Parcelable.Creator<CheeseBurger> CREATOR = new Parcelable.Creator<CheeseBurger>() {
            @Override
            public CheeseBurger createFromParcel(Parcel source) {
                return new CheeseBurger(source);
            }

            @Override
            public CheeseBurger[] newArray(int size) {
                return new CheeseBurger[size];
            }
        };
    }
    public static class FrenchFries implements Parcelable {


        boolean isAnimalStyle = false;

        public boolean getAnimalStyle() {
            return isAnimalStyle;
        }

        public void setAnimalStyle() { isAnimalStyle = !isAnimalStyle; }

        @Override
        public String toString() {
            double price = getFrenchFriesPrice();
            String s = "FF";
            if (isAnimalStyle) {
                s += "\n\tAnimal Style";
                price = getFrenchFriesPrice()+animalStyleFriesPrice;
            }

            s+="\n\t\t\t\t\t\t$" + df.format(price);
            return s;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isAnimalStyle ? (byte) 1 : (byte) 0);
        }

        public FrenchFries() {
        }

        protected FrenchFries(Parcel in) {
            this.isAnimalStyle = in.readByte() != 0;
        }

        public static final Parcelable.Creator<FrenchFries> CREATOR = new Parcelable.Creator<FrenchFries>() {
            @Override
            public FrenchFries createFromParcel(Parcel source) {
                return new FrenchFries(source);
            }

            @Override
            public FrenchFries[] newArray(int size) {
                return new FrenchFries[size];
            }
        };
    }

    /** Basically if ordering off the normal menu, you'll get to choose one flavor.
     * If you order off the secret menu, you'll get to mix */
    public static class Shake implements Parcelable {

        // vanilla by default
        boolean [] flavor = {/*vanilla */true, /*chocolate*/false, /*strawberry*/false};
        boolean isLarge = false;

        /** make a shake of a certain flavor with this constructor*/
        public Shake(int i) {
            switch (i) {
                    //vanilla
                case(1):
                    break;
                    // chocolate
                case (2):
                    flavor[0] = false;
                    flavor[1] = true;
                    break;
                    // strawberry
                case (3):
                    flavor[0] = false;
                    flavor[2] = true;
                    break;
                    //vanilla
                default:
                    break;
            }
        }

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
        public int getFlavor() {
            if (flavor[0])
                return 1;
            else if(flavor[1])
                return 2;
            else if(flavor[2])
                return 3;
            else
                return -1;
        }
        public boolean[] getFlavors() {
            boolean[] flavors = new boolean[3];
            if (flavor[0])
                flavors[0]= true;
            else
                flavors[0]=false;

            if (flavor[1])
                flavors[1] = true;
            else
                flavors[1] = false;

            if (flavor[2])
                flavors[2] = true;
            else
                flavors[2] = false;

            return flavors;


        }

        // secret menu functions
        public void addFlavor(int f) {
            if (f < 1 || f > 3) { System.out.println("Called with invalid argument. Should be between 1-3"); return; }
            flavor[f-1] = true;
        }
        public void removeFlavor(int f) {
            if (f < 1 || f > 3) { System.out.println("Called with invalid argument. Should be between 1-3"); return; }
            flavor[f-1] = false;
            /** we can't have a flavorless shake, so if they're all false set it to vanilla by default */
            if (!flavor[0] && !flavor[1] && !flavor[2])
                flavor[0] = true;
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

            s+="\n\t\t\t\t\t\t$" + df.format(getShakePrice());


            return s;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBooleanArray(this.flavor);
            dest.writeByte(this.isLarge ? (byte) 1 : (byte) 0);
        }

        public Shake() {
        }

        protected Shake(Parcel in) {
            this.flavor = in.createBooleanArray();
            this.isLarge = in.readByte() != 0;
        }

        public static final Creator<Shake> CREATOR = new Creator<Shake>() {
            @Override
            public Shake createFromParcel(Parcel source) {
                return new Shake(source);
            }

            @Override
            public Shake[] newArray(int size) {
                return new Shake[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.doubleDouble);
        dest.writeTypedList(this.cheeseBurger);
        dest.writeTypedList(this.frenchFries);
        dest.writeTypedList(this.shake);
        dest.writeInt(this.smallDrinks);
        dest.writeInt(this.mediumDrinks);
        dest.writeInt(this.largeDrinks);
        dest.writeDouble(this.subTotal);
        dest.writeDouble(this.tax);
        dest.writeDouble(this.total);
        dest.writeInt(this.doubleDoubleQuant);
        dest.writeInt(this.cheeseburgerQuant);
        dest.writeInt(this.fryQuant);
        dest.writeInt(this.shakeQuant);
        dest.writeInt(this.totalItems);
    }

    protected Order(Parcel in) {
        this.doubleDouble = in.createTypedArrayList(DoubleDouble.CREATOR);
        this.cheeseBurger = in.createTypedArrayList(CheeseBurger.CREATOR);
        this.frenchFries = in.createTypedArrayList(FrenchFries.CREATOR);
        this.shake = in.createTypedArrayList(Shake.CREATOR);
        this.smallDrinks = in.readInt();
        this.mediumDrinks = in.readInt();
        this.largeDrinks = in.readInt();
        this.subTotal = in.readDouble();
        this.tax = in.readDouble();
        this.total = in.readDouble();
        this.doubleDoubleQuant = in.readInt();
        this.cheeseburgerQuant = in.readInt();
        this.fryQuant = in.readInt();
        this.shakeQuant = in.readInt();
        this.totalItems = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
