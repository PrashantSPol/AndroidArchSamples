package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

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

public class InSaleSellingFragmentViewModel extends BaseViewModel {
    public ObservableField<List<Product>> productList = new ObservableField<>(new ArrayList<>());
    MutableLiveData<List<Product>> productLiveData = new MutableLiveData<>();

    void loadData(DataManager dataManager) {
        Log.i("CHECK_", "load Data called");
        compositeDisposable.add(dataManager
                .getInSaleProductList().subscribe(list -> {
                    Log.i("CHECK_", "setting data to mutable list " + list);
            productLiveData.setValue(list);
        }));
    }

    void setProductList(List<Product> productList) {
        this.productList.set(productList);
    }
}
