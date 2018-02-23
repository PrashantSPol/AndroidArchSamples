package com.polstech.library.androidarchsamples.ui.sellingList.common;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;

/**
 * Created by prashant.pol on 2/23/2018.
 */

public class SellingListElementViewModel extends BaseViewModel {
    public ObservableField<String> productName = new ObservableField<>();
    public ObservableField<Integer> imageUrl = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();

    public void setProduct(Product product) {
        if(product == null) {
            return;
        }

        productName.set(product.productName);
        imageUrl.set(product.imageUrl);
        price.set(String.valueOf(product.price));
    }

    @BindingAdapter({"imageUrl"})
    public static void binding(ImageView imageView, int drawableRes) {
        imageView.setBackgroundResource(drawableRes);
    }

    public ObservableField<String> getProductName() {
        return productName;
    }

    public ObservableField<Integer> getImageUrl() {
        return imageUrl;
    }

    public ObservableField<String> getPrice() {
        return price;
    }
}
