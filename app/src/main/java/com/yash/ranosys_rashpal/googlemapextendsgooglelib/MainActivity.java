package com.yash.ranosys_rashpal.googlemapextendsgooglelib;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MapFragmentProject mapFragmentProject;

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5;

    private String placeTypeString;
    private String radius = "3000";
    private ArrayList resultList;
    private AutoCompleteTextView autoCompPlaceSearch;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragmentProject = new MapFragmentProject();

       addFragment(R.id.fragment_container,
             mapFragmentProject ,
                "1");

        context = this;


        materialDesignFAM = (FloatingActionMenu) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_floating_action_menu_item3);
        floatingActionButton4 = (FloatingActionButton) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_floating_action_menu_item4);
        floatingActionButton5 = (FloatingActionButton) findViewById(com.yash.ranosys_rashpal.locationfusedproviderexa.R.id.material_design_floating_action_menu_item5);


        autoCompPlaceSearch = (AutoCompleteTextView) findViewById(R.id.place_search_auto);

        Button getPath = (Button) findViewById(R.id.get_path_btn);

        getPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompPlaceSearch.setVisibility(View.VISIBLE);
                mapFragmentProject.getPathBetweenSourceDestination(context, autoCompPlaceSearch);
            }
        });


        Button nearLocation = (Button) findViewById(R.id.set_near_places);
        nearLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDesignFAM.setVisibility(View.VISIBLE);
            }
        });

        Button set_current_location = (Button) findViewById(R.id.set_current_location);
        set_current_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragmentProject.setCurrentLocation();
            }
        });

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

                placeTypeString = "ATM";
                mapFragmentProject.getLocationByType(placeTypeString, radius, context, autoCompPlaceSearch);
                autoCompPlaceSearch.setVisibility(View.GONE);
                materialDesignFAM.close(false);

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                placeTypeString = "hospital";
                mapFragmentProject.getLocationByType(placeTypeString, radius, context, autoCompPlaceSearch);
                autoCompPlaceSearch.setVisibility(View.GONE);
                materialDesignFAM.close(false);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

                placeTypeString = "restaurant";
                mapFragmentProject.getLocationByType(placeTypeString, radius, context, autoCompPlaceSearch);
                autoCompPlaceSearch.setVisibility(View.GONE);
                materialDesignFAM.close(false);
            }
        });


        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                placeTypeString = "police";
                mapFragmentProject.getLocationByType(placeTypeString, radius, context, autoCompPlaceSearch);
                autoCompPlaceSearch.setVisibility(View.GONE);
                materialDesignFAM.close(false);
            }
        });




        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                autoCompPlaceSearch.setVisibility(View.VISIBLE);

                materialDesignFAM.close(false);
                mapFragmentProject.setNearPlaceAdapter(radius, context, autoCompPlaceSearch);

            }

        /*  // Method #1
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(this);
        autocompleteFragment.setHint("Search a Location");

        autocompleteFragment.setBoundsBias(BOUNDS_MOUNTAIN_VIEW);*/


        });

    }

    protected void addFragment(@IdRes int containerViewId,
                               @NonNull Fragment fragment,
                               @NonNull String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();

    }



}