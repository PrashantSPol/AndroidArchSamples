package pol.prashant.sample.viewmodelsample.logic;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.HashMap;

/**
 * Created by prashant.pol on 12/25/2017.
 */

public class DataViewModel extends ViewModel {

    MutableLiveData<HashMap<String, String>> data;
    MutableLiveData<String> selected;

    public MutableLiveData<HashMap<String, String>> getData() {
        if(data == null) {
            data = new MutableLiveData<HashMap<String, String>>();
            data.setValue(DataProvider.getInstance().getData());
        }

        return data;
    }

    public void setSelected(String value) {
        selected.postValue(value);
    }

    public MutableLiveData<String> getSelected() {
        if(selected == null) {
            selected = new MutableLiveData<>();
        }
        return selected;
    }
}
