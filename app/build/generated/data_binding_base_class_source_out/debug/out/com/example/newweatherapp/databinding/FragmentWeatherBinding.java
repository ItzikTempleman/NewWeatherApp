// Generated by view binder compiler. Do not edit!
package com.example.newweatherapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.newweatherapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWeatherBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar activityMainProgressbar;

  @NonNull
  public final RecyclerView fragmentMainRecyclerView;

  @NonNull
  public final ImageView getLocationBtn;

  @NonNull
  public final RadioButton imperialRadioButton;

  @NonNull
  public final RadioButton metricRadioButton;

  @NonNull
  public final AppCompatImageView searchCityEt;

  @NonNull
  public final RadioGroup unitTypeRadioGroup;

  private FragmentWeatherBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar activityMainProgressbar, @NonNull RecyclerView fragmentMainRecyclerView,
      @NonNull ImageView getLocationBtn, @NonNull RadioButton imperialRadioButton,
      @NonNull RadioButton metricRadioButton, @NonNull AppCompatImageView searchCityEt,
      @NonNull RadioGroup unitTypeRadioGroup) {
    this.rootView = rootView;
    this.activityMainProgressbar = activityMainProgressbar;
    this.fragmentMainRecyclerView = fragmentMainRecyclerView;
    this.getLocationBtn = getLocationBtn;
    this.imperialRadioButton = imperialRadioButton;
    this.metricRadioButton = metricRadioButton;
    this.searchCityEt = searchCityEt;
    this.unitTypeRadioGroup = unitTypeRadioGroup;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWeatherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWeatherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_weather, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWeatherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.activity_main_progressbar;
      ProgressBar activityMainProgressbar = ViewBindings.findChildViewById(rootView, id);
      if (activityMainProgressbar == null) {
        break missingId;
      }

      id = R.id.fragment_main_recycler_view;
      RecyclerView fragmentMainRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (fragmentMainRecyclerView == null) {
        break missingId;
      }

      id = R.id.get_location_btn;
      ImageView getLocationBtn = ViewBindings.findChildViewById(rootView, id);
      if (getLocationBtn == null) {
        break missingId;
      }

      id = R.id.imperial_radio_button;
      RadioButton imperialRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (imperialRadioButton == null) {
        break missingId;
      }

      id = R.id.metric_radio_button;
      RadioButton metricRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (metricRadioButton == null) {
        break missingId;
      }

      id = R.id.search_city_et;
      AppCompatImageView searchCityEt = ViewBindings.findChildViewById(rootView, id);
      if (searchCityEt == null) {
        break missingId;
      }

      id = R.id.unit_type_radio_group;
      RadioGroup unitTypeRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (unitTypeRadioGroup == null) {
        break missingId;
      }

      return new FragmentWeatherBinding((ConstraintLayout) rootView, activityMainProgressbar,
          fragmentMainRecyclerView, getLocationBtn, imperialRadioButton, metricRadioButton,
          searchCityEt, unitTypeRadioGroup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
