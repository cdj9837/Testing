package com.random.testing;

import java.io.Serializable;

class IngredientTest implements Serializable {
    String Name;
    String Notes;
    String Unit;
    double IngredientID;
    String DisplayAmount;
    double Amount;

    public IngredientTest(){}

    public IngredientTest(String Name, String Unit, String DisplayAmount)
    {
        this.Name = Name;
        this.Unit = Unit;
        this.DisplayAmount = DisplayAmount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public double getIngredientID() {
        return IngredientID;
    }

    public void setIngredientID(double ingredientID) {
        IngredientID = ingredientID;
    }

    public String getDisplayAmount() {
        return DisplayAmount;
    }

    public void setDisplayAmount(String displayAmount) {
        DisplayAmount = displayAmount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}

