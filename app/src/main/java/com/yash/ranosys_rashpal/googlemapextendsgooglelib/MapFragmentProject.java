package com.yash.ranosys_rashpal.googlemapextendsgooglelib;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.yash.ranosys_rashpal.locationfusedproviderexa.Activity.MapFragmentLocal;

/**
 * Created by ranosys-rashpal on 27/1/17.
 */

public class MapFragmentProject extends Fragment {

    MapFragmentLocal mapFragment;
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


     View rootView = inflater.inflate(R.layout.fragment_map_project, container, false);


    FragmentManager fm = getActivity().getSupportFragmentManager();
       mapFragment = new MapFragmentLocal();

       fm.beginTransaction()
               .add(R.id.fragment_container, mapFragment)
               .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
               .commit();
         return rootView;

   }

    public void setMarker(){
        mapFragment.setMarker(26.7762159,75.8320607);
    }

    public void setCurrentLocation(){
        mapFragment.setCurrentLocation();
    }

    public void getLocationByType(String placeTypeString, String radius, Context context , AutoCompleteTextView autoCompleteTextView){
        mapFragment.getLocationByType(placeTypeString, radius, context , autoCompleteTextView);
    }


    public void setNearPlaceAdapter(String radius, Context context , AutoCompleteTextView autoCompleteTextView){
        mapFragment.setNearPlaceAdapter( context , autoCompleteTextView, radius);
    }


    public void getPathBetweenSourceDestination(Context context, AutoCompleteTextView autoCompleteTextView){
        mapFragment.getPathBetweenSourceDestination(context, autoCompleteTextView);
    }
}
