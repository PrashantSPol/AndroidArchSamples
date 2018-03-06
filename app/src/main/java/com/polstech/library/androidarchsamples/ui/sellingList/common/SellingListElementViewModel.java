package com.polstech.library.androidarchsamples.ui.sellingList.common;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;

/**
 * Created by prashant.pol on 2/23/2018.
 */

public class SellingListElementViewModel extends BaseViewModel {
    public ObservableField<String> productName = new ObservableField<>();
    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<Boolean> isInSale = new ObservableField<>();

    public void setProduct(Product product) {
        if(product == null) {
            return;
        }

        productName.set(product.productName);
        imageUrl.set(product.imageUrl);
        price.set(String.valueOf(product.price));
        isInSale.set(product.isInSale);
    }

    @BindingAdapter({"imageUrl"})
    public static void binding(ImageView imageView, String imageUrl) {
        Log.i("CHECK_", "Loading image " + imageUrl);
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    public ObservableField<String> getProductName() {
        return productName;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public ObservableField<String> getPrice() {
        return price;
    }
}
