package com.random.testing;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static final String TAG = "MainActivity";
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    ListView inventoryLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inventoryLV = (ListView) findViewById(R.id.inventoryLV);

        /*IngredientTest i1 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i2 = new IngredientTest("Milk", "cup", "4");
        IngredientTest i3 = new IngredientTest("Sour Cream", "cup", "2");
        IngredientTest i4 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i5 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i6 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i7 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i8 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i9 = new IngredientTest("Egg", "egg", "12");
        IngredientTest i10 = new IngredientTest("Egg", "egg", "12");

        ArrayList<IngredientTest> ingredientList = new ArrayList<>();

        ingredientList.add(i1);
        ingredientList.add(i2);
        ingredientList.add(i3);
        ingredientList.add(i4);
        ingredientList.add(i5);
        ingredientList.add(i6);
        ingredientList.add(i7);
        ingredientList.add(i8);
        ingredientList.add(i9);
        ingredientList.add(i10);

        //RecipeListAdapter adapter = new RecipeListAdapter(this, R.layout.recipe_list_item_layout, recipeList);
        //recipeLV.setAdapter(adapter);


        IngredientsListAdapter adapter = new IngredientsListAdapter(this,R.layout.ingredient_list_layout,ingredientList);
        inventoryLV.setAdapter(adapter);*/

        final ArrayList<Ingredients> ingredientList = new ArrayList<>();

        mRootRef.child("Inventory").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    for (DataSnapshot inventorySnapShot : dataSnapshot.getChildren()) {
                        Ingredients r = inventorySnapShot.getValue(Ingredients.class);
                        ingredientList.add(r);
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "onCancelled: ", databaseError.toException() );
            }
        });

        IngredientsListAdapter adapter = new IngredientsListAdapter(this,R.layout.ingredient_list_layout,ingredientList);
        inventoryLV.setAdapter(adapter);

        //what do on click of item
        /*inventoryLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openRecipeInfoActivity(recipeList.get(position));
                //position is index of clicked item in list view

            }
        });*/
    //}
    }
}