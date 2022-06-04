package com.example.newweatherapp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/newweatherapp/adapters/ForecastAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/newweatherapp/adapters/ForecastAdapter$ForecastViewHolder;", "()V", "currentTextColors", "", "forecastList", "", "Lcom/example/newweatherapp/models/forecast/ForecastListItem;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateForecast", "updatedList", "", "ForecastViewHolder", "app_debug"})
public final class ForecastAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.newweatherapp.adapters.ForecastAdapter.ForecastViewHolder> {
    private int currentTextColors = android.graphics.Color.BLACK;
    private final java.util.List<com.example.newweatherapp.models.forecast.ForecastListItem> forecastList = null;
    
    public ForecastAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.newweatherapp.adapters.ForecastAdapter.ForecastViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.adapters.ForecastAdapter.ForecastViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateForecast(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.forecast.ForecastListItem> updatedList) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/newweatherapp/adapters/ForecastAdapter$ForecastViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/newweatherapp/databinding/ForecastItemViewBinding;", "(Lcom/example/newweatherapp/databinding/ForecastItemViewBinding;)V", "getBinding", "()Lcom/example/newweatherapp/databinding/ForecastItemViewBinding;", "app_debug"})
    public static final class ForecastViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.newweatherapp.databinding.ForecastItemViewBinding binding = null;
        
        public ForecastViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.newweatherapp.databinding.ForecastItemViewBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.newweatherapp.databinding.ForecastItemViewBinding getBinding() {
            return null;
        }
    }
}