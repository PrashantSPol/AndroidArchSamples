package pol.prashant.sample.viewmodelsample.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pol.prashant.sample.viewmodelsample.R;
import pol.prashant.sample.viewmodelsample.logic.DataViewModel;

/**
 * Created by prashant.pol on 12/25/2017.
 */

public class DisplayFragment extends Fragment {

    View rootView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_display, null);
        textView = (TextView) rootView.findViewById(R.id.txt_display);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MutableLiveData<String> mutableLiveData = ViewModelProviders.of(getActivity()).get(DataViewModel.class).getSelected();
        mutableLiveData.observe(this, value -> {
            textView.setText(value);
        });
    }
}
