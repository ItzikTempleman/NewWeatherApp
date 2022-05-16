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
import androidx.appcompat.widget.AppCompatTextView;
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
  public final View bottomLeftDividerLine;

  @NonNull
  public final View bottomRightDividerLine;

  @NonNull
  public final AppCompatTextView cityNameTv;

  @NonNull
  public final AppCompatTextView countryNameTv;

  @NonNull
  public final View dividerLine;

  @NonNull
  public final AppCompatTextView feelsLikeTv;

  @NonNull
  public final AppCompatTextView feelsLikeUnitTv;

  @NonNull
  public final AppCompatTextView feelsLikeValueTv;

  @NonNull
  public final RecyclerView forecastRecyclerView;

  @NonNull
  public final ConstraintLayout fragmentWeatherContainer;

  @NonNull
  public final ImageView getLocationBtn;

  @NonNull
  public final View horizontalBottomLine;

  @NonNull
  public final View horizontalTopLine;

  @NonNull
  public final AppCompatTextView humidityPercentTv;

  @NonNull
  public final AppCompatTextView humidityTv;

  @NonNull
  public final AppCompatTextView humidityValueTv;

  @NonNull
  public final ImageView iconIv;

  @NonNull
  public final RadioButton imperialRadioButton;

  @NonNull
  public final AppCompatTextView mainTv;

  @NonNull
  public final RadioButton metricRadioButton;

  @NonNull
  public final AppCompatTextView rainTv;

  @NonNull
  public final AppCompatTextView rainValueTv;

  @NonNull
  public final ImageView saveWeatherIv;

  @NonNull
  public final AppCompatImageView searchCityEt;

  @NonNull
  public final AppCompatTextView snowTv;

  @NonNull
  public final AppCompatTextView snowValueTv;

  @NonNull
  public final AppCompatTextView temperatureTv;

  @NonNull
  public final AppCompatTextView temperatureUnitTv;

  @NonNull
  public final RadioGroup unitTypeRadioGroup;

  @NonNull
  public final AppCompatTextView windTv;

  @NonNull
  public final AppCompatTextView windValueMmTv;

  @NonNull
  public final AppCompatTextView windValueTv;

  private FragmentWeatherBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar activityMainProgressbar, @NonNull View bottomLeftDividerLine,
      @NonNull View bottomRightDividerLine, @NonNull AppCompatTextView cityNameTv,
      @NonNull AppCompatTextView countryNameTv, @NonNull View dividerLine,
      @NonNull AppCompatTextView feelsLikeTv, @NonNull AppCompatTextView feelsLikeUnitTv,
      @NonNull AppCompatTextView feelsLikeValueTv, @NonNull RecyclerView forecastRecyclerView,
      @NonNull ConstraintLayout fragmentWeatherContainer, @NonNull ImageView getLocationBtn,
      @NonNull View horizontalBottomLine, @NonNull View horizontalTopLine,
      @NonNull AppCompatTextView humidityPercentTv, @NonNull AppCompatTextView humidityTv,
      @NonNull AppCompatTextView humidityValueTv, @NonNull ImageView iconIv,
      @NonNull RadioButton imperialRadioButton, @NonNull AppCompatTextView mainTv,
      @NonNull RadioButton metricRadioButton, @NonNull AppCompatTextView rainTv,
      @NonNull AppCompatTextView rainValueTv, @NonNull ImageView saveWeatherIv,
      @NonNull AppCompatImageView searchCityEt, @NonNull AppCompatTextView snowTv,
      @NonNull AppCompatTextView snowValueTv, @NonNull AppCompatTextView temperatureTv,
      @NonNull AppCompatTextView temperatureUnitTv, @NonNull RadioGroup unitTypeRadioGroup,
      @NonNull AppCompatTextView windTv, @NonNull AppCompatTextView windValueMmTv,
      @NonNull AppCompatTextView windValueTv) {
    this.rootView = rootView;
    this.activityMainProgressbar = activityMainProgressbar;
    this.bottomLeftDividerLine = bottomLeftDividerLine;
    this.bottomRightDividerLine = bottomRightDividerLine;
    this.cityNameTv = cityNameTv;
    this.countryNameTv = countryNameTv;
    this.dividerLine = dividerLine;
    this.feelsLikeTv = feelsLikeTv;
    this.feelsLikeUnitTv = feelsLikeUnitTv;
    this.feelsLikeValueTv = feelsLikeValueTv;
    this.forecastRecyclerView = forecastRecyclerView;
    this.fragmentWeatherContainer = fragmentWeatherContainer;
    this.getLocationBtn = getLocationBtn;
    this.horizontalBottomLine = horizontalBottomLine;
    this.horizontalTopLine = horizontalTopLine;
    this.humidityPercentTv = humidityPercentTv;
    this.humidityTv = humidityTv;
    this.humidityValueTv = humidityValueTv;
    this.iconIv = iconIv;
    this.imperialRadioButton = imperialRadioButton;
    this.mainTv = mainTv;
    this.metricRadioButton = metricRadioButton;
    this.rainTv = rainTv;
    this.rainValueTv = rainValueTv;
    this.saveWeatherIv = saveWeatherIv;
    this.searchCityEt = searchCityEt;
    this.snowTv = snowTv;
    this.snowValueTv = snowValueTv;
    this.temperatureTv = temperatureTv;
    this.temperatureUnitTv = temperatureUnitTv;
    this.unitTypeRadioGroup = unitTypeRadioGroup;
    this.windTv = windTv;
    this.windValueMmTv = windValueMmTv;
    this.windValueTv = windValueTv;
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

      id = R.id.bottom_left_divider_line;
      View bottomLeftDividerLine = ViewBindings.findChildViewById(rootView, id);
      if (bottomLeftDividerLine == null) {
        break missingId;
      }

      id = R.id.bottom_right_divider_line;
      View bottomRightDividerLine = ViewBindings.findChildViewById(rootView, id);
      if (bottomRightDividerLine == null) {
        break missingId;
      }

      id = R.id.city_name_tv;
      AppCompatTextView cityNameTv = ViewBindings.findChildViewById(rootView, id);
      if (cityNameTv == null) {
        break missingId;
      }

      id = R.id.country_name_tv;
      AppCompatTextView countryNameTv = ViewBindings.findChildViewById(rootView, id);
      if (countryNameTv == null) {
        break missingId;
      }

      id = R.id.divider_line;
      View dividerLine = ViewBindings.findChildViewById(rootView, id);
      if (dividerLine == null) {
        break missingId;
      }

      id = R.id.feels_like_tv;
      AppCompatTextView feelsLikeTv = ViewBindings.findChildViewById(rootView, id);
      if (feelsLikeTv == null) {
        break missingId;
      }

      id = R.id.feels_like_unit_tv;
      AppCompatTextView feelsLikeUnitTv = ViewBindings.findChildViewById(rootView, id);
      if (feelsLikeUnitTv == null) {
        break missingId;
      }

      id = R.id.feels_like_value_tv;
      AppCompatTextView feelsLikeValueTv = ViewBindings.findChildViewById(rootView, id);
      if (feelsLikeValueTv == null) {
        break missingId;
      }

      id = R.id.forecast_recycler_view;
      RecyclerView forecastRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (forecastRecyclerView == null) {
        break missingId;
      }

      ConstraintLayout fragmentWeatherContainer = (ConstraintLayout) rootView;

      id = R.id.get_location_btn;
      ImageView getLocationBtn = ViewBindings.findChildViewById(rootView, id);
      if (getLocationBtn == null) {
        break missingId;
      }

      id = R.id.horizontal_bottom_line;
      View horizontalBottomLine = ViewBindings.findChildViewById(rootView, id);
      if (horizontalBottomLine == null) {
        break missingId;
      }

      id = R.id.horizontal_top_line;
      View horizontalTopLine = ViewBindings.findChildViewById(rootView, id);
      if (horizontalTopLine == null) {
        break missingId;
      }

      id = R.id.humidity_percent_tv;
      AppCompatTextView humidityPercentTv = ViewBindings.findChildViewById(rootView, id);
      if (humidityPercentTv == null) {
        break missingId;
      }

      id = R.id.humidity_tv;
      AppCompatTextView humidityTv = ViewBindings.findChildViewById(rootView, id);
      if (humidityTv == null) {
        break missingId;
      }

      id = R.id.humidity_value_tv;
      AppCompatTextView humidityValueTv = ViewBindings.findChildViewById(rootView, id);
      if (humidityValueTv == null) {
        break missingId;
      }

      id = R.id.icon_iv;
      ImageView iconIv = ViewBindings.findChildViewById(rootView, id);
      if (iconIv == null) {
        break missingId;
      }

      id = R.id.imperial_radio_button;
      RadioButton imperialRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (imperialRadioButton == null) {
        break missingId;
      }

      id = R.id.main_tv;
      AppCompatTextView mainTv = ViewBindings.findChildViewById(rootView, id);
      if (mainTv == null) {
        break missingId;
      }

      id = R.id.metric_radio_button;
      RadioButton metricRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (metricRadioButton == null) {
        break missingId;
      }

      id = R.id.rain_tv;
      AppCompatTextView rainTv = ViewBindings.findChildViewById(rootView, id);
      if (rainTv == null) {
        break missingId;
      }

      id = R.id.rain_value_tv;
      AppCompatTextView rainValueTv = ViewBindings.findChildViewById(rootView, id);
      if (rainValueTv == null) {
        break missingId;
      }

      id = R.id.save_weather_iv;
      ImageView saveWeatherIv = ViewBindings.findChildViewById(rootView, id);
      if (saveWeatherIv == null) {
        break missingId;
      }

      id = R.id.search_city_et;
      AppCompatImageView searchCityEt = ViewBindings.findChildViewById(rootView, id);
      if (searchCityEt == null) {
        break missingId;
      }

      id = R.id.snow_tv;
      AppCompatTextView snowTv = ViewBindings.findChildViewById(rootView, id);
      if (snowTv == null) {
        break missingId;
      }

      id = R.id.snow_value_tv;
      AppCompatTextView snowValueTv = ViewBindings.findChildViewById(rootView, id);
      if (snowValueTv == null) {
        break missingId;
      }

      id = R.id.temperature_tv;
      AppCompatTextView temperatureTv = ViewBindings.findChildViewById(rootView, id);
      if (temperatureTv == null) {
        break missingId;
      }

      id = R.id.temperature_unit_tv;
      AppCompatTextView temperatureUnitTv = ViewBindings.findChildViewById(rootView, id);
      if (temperatureUnitTv == null) {
        break missingId;
      }

      id = R.id.unit_type_radio_group;
      RadioGroup unitTypeRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (unitTypeRadioGroup == null) {
        break missingId;
      }

      id = R.id.wind_tv;
      AppCompatTextView windTv = ViewBindings.findChildViewById(rootView, id);
      if (windTv == null) {
        break missingId;
      }

      id = R.id.wind_value_mm_tv;
      AppCompatTextView windValueMmTv = ViewBindings.findChildViewById(rootView, id);
      if (windValueMmTv == null) {
        break missingId;
      }

      id = R.id.wind_value_tv;
      AppCompatTextView windValueTv = ViewBindings.findChildViewById(rootView, id);
      if (windValueTv == null) {
        break missingId;
      }

      return new FragmentWeatherBinding((ConstraintLayout) rootView, activityMainProgressbar,
          bottomLeftDividerLine, bottomRightDividerLine, cityNameTv, countryNameTv, dividerLine,
          feelsLikeTv, feelsLikeUnitTv, feelsLikeValueTv, forecastRecyclerView,
          fragmentWeatherContainer, getLocationBtn, horizontalBottomLine, horizontalTopLine,
          humidityPercentTv, humidityTv, humidityValueTv, iconIv, imperialRadioButton, mainTv,
          metricRadioButton, rainTv, rainValueTv, saveWeatherIv, searchCityEt, snowTv, snowValueTv,
          temperatureTv, temperatureUnitTv, unitTypeRadioGroup, windTv, windValueMmTv, windValueTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}