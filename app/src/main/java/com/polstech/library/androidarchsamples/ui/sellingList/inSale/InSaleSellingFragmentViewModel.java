package com.polstech.library.androidarchsamples.ui.sellingList.inSale;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.ui.common.BaseViewModel;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;
import com.polstech.library.androidarchsamples.ui.sellingList.common.SellingListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public class InSaleSellingFragmentViewModel extends BaseViewModel {
    public ObservableField<List<Product>> productList = new ObservableField<>(new ArrayList<>());
    MutableLiveData<List<Product>> productLiveData = new MutableLiveData<>();

    void loadData(DataManager dataManager) {
        Log.i("CHECK_", "load Data called");
        compositeDisposable.add(dataManager
                .getProductList().subscribe(list -> {
                    Log.i("CHECK_", "setting data to mutable list " + list);
            productLiveData.setValue(list);
        }));
    }

    void setProductList(List<Product> productList) {
        this.productList.set(productList);
    }
}
