/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.flavor;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.flavor.R.*;
import static com.example.android.flavor.R.id.list_item;
import static com.example.android.flavor.R.id.listview_flavor;
import static com.example.android.flavor.R.id.text;
import static com.example.android.flavor.R.id.version_name;

/**
 * {@link FlavorActivity} shows a list of Android platform releases.
 * For each release, display the name, version number, and image.
 * @version 1.1 this has since been modified to display wearable merchandise like t-shirts, and caps
 * the titles for the orginial array are still intact but values have been altered.
 */
public class FlavorActivity extends AppCompatActivity {

    private AdapterView listView;
    private ArrayAdapter<String>[] listAdapter;
    private AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_flavor);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("T- Shirt  €5.00 +VAT", "XS,S,M,L,XL,XXL", drawable.tshirt));
        androidFlavors.add(new AndroidFlavor("Hoodie    €10.00 +VAT", "XS,S,M,L,XL,XXL", drawable.hoodie));
        androidFlavors.add(new AndroidFlavor("Polo  €6.50 +VAT", "XS,S,M,L,XL,XXL", drawable.polo));
        androidFlavors.add(new AndroidFlavor("Vest/Tank  €5.75 +VAT", "XS,S,M,L,XL,XXL", drawable.vest));
        androidFlavors.add(new AndroidFlavor("Ball Cap   €12.00 +VAT", "Adjustable", drawable.ballcap));


        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        final AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) findViewById(id.listview_flavor);
        listView.setAdapter(flavorAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * Below we have the toast method and we are trying to parse the array into the new variable item.
             * AndroidFlavor(String vName, String vNumber, int imageResourceId)
             *
             * @param parent
             * @param view
             * @param position
             * @param id
             **/
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                TextView textView = view.findViewById(R.id.version_name);
                // Display a Toast message indicting the selected item
                Toast.makeText(FlavorActivity.this, textView.getText(),
                        Toast.LENGTH_LONG)
                        .show();
            }


        });

    }
}


