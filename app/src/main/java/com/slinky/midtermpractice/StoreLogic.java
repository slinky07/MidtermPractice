package com.slinky.midtermpractice;

import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class StoreLogic {
    private double total;
    private volatile static StoreLogic logicInstance;

    public double milk = 3;
    public double egg = 2;
    public double beef = 23;
    public double soda = 1;
    public double biscuits = 2.5;
    public double fruits = 6.5;
    public double veges = 4;

    private StoreLogic() {}

    public static StoreLogic getInstance() {
        if (logicInstance==null) {
            synchronized (StoreLogic.class) {
                if (logicInstance== null){
                    logicInstance = new StoreLogic();
                }
            }
        }
        return logicInstance;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * is the Add column item checked
     * @param cb is checkbox item from ADD column
     * @return true if it is checked
     */
    private boolean isChecked(CheckBox cb) {
        return cb.isChecked();
    }

    /**
     * is the numerical value being checked frm QTY column
     * @param ed is editText element being checked with solely number value
     * @return true if more than zero
     */
    private boolean isMoreThanZero(EditText ed) {
        return Double.parseDouble(ed.getText().toString()) > 0;
    }

    /**
     * main method being called to check form total <br><br>
     *
     * has try/catch cause of fatal exception bring thrown when checkbox is checked but EditText is empty.
     * <br> checking for empty field did not solve the issue. <br><br>
     * from what i read, TextUtil.isEmpty(str) could solve this issue
     * @param cb is checkbox element from given row
     * @param ed is editText element from given row
     * @param price is price element hardcoded in this class.
     */
    public void totalGateway(CheckBox cb, EditText ed, Double price) {
        Log.d("mainActivity", "before IF");

        try {
            if (isChecked(cb) && isMoreThanZero(ed)) {
                Log.d("mainActivity", "inside IF");
                doTotal(ed, price);

            }
        } catch (NumberFormatException e) {
            Log.e("Total Gateway Error", e.toString());
        }
    }

    /**
     * actual calculation method
     * @param ed is editText element containing the QTY to multiply by.
     * @param price is price of element being bought
     */
    private void doTotal(EditText ed, double price) {
        total += price * Double.parseDouble(ed.getText().toString());
    }
}
