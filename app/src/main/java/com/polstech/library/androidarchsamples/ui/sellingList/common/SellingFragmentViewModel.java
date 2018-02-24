package com.polstech.library.androidarchsamples.ui.sellingList.common;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class SellingFragmentViewModel extends BaseViewModel {
    public ObservableField<List<Product>> productList = new ObservableField<>(new ArrayList<>());
    public MutableLiveData<List<Product>> productLiveData = new MutableLiveData<>();

    public void loadInSaleProducts(DataManager dataManager) {
        compositeDisposable.add(dataManager
                .getInSaleProductList().subscribe(list -> {
            productLiveData.setValue(list);
        }));
    }

    public void loadSoldOutProducts(DataManager dataManager) {
        compositeDisposable.add(dataManager
                .getSoldOutProductList().subscribe(list -> {
                    Log.i("CHECK_", "Sold composite " + list);
                    productLiveData.setValue(list);
                }));
    }

    public void setProductList(List<Product> productList) {
        this.productList.set(productList);
    }
}
