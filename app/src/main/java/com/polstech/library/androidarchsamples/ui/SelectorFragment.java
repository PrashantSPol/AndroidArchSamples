package com.polstech.library.androidarchsamples.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.logic.DataProvider;
import com.polstech.library.androidarchsamples.logic.DataViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by prashant.pol on 12/25/2017.
 */

public class SelectorFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;
    private Button btnRefresh;
    private MutableLiveData<String> selected;
    private CompositeDisposable compositeDisposable;

    private HashMap<String, String> dataMap;
    private TitleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_selector, null);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_titles);
        btnRefresh = (Button) rootView.findViewById(R.id.btn_refresh);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUI();
    }

    private void setUI() {
        DataViewModel dataViewModel = ViewModelProviders.of(getActivity()).get(DataViewModel.class);
        dataMap = dataViewModel.getData().getValue();
        if(dataMap == null) {
            return;
        }

        selected = ViewModelProviders.of(getActivity()).get(DataViewModel.class).getSelected();

        adapter = new TitleAdapter(getContext(), new ArrayList<String>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setObservable();
            }
        });
    }

    private void setObservable() {
        if(compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        DisposableObserver<HashMap<String, String>> disposableObserver = getDisposableObserver();

        Observable.fromCallable(new Callable<HashMap<String, String>>(){
            @Override
            public HashMap<String, String> call() throws Exception {
                return DataProvider.getInstance().getData();
            }
        }).observeOn(AndroidSchedulers.mainThread())
          .subscribeOn(Schedulers.io())
          .subscribe(disposableObserver);

        compositeDisposable.add(disposableObserver);

    }

    private DisposableObserver<HashMap<String, String>> getDisposableObserver() {
        return new DisposableObserver<HashMap<String, String>>() {
            @Override
            public void onNext(HashMap<String, String> dataMap) {
                SelectorFragment.this.dataMap = dataMap;
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                adapter.setTitles(new ArrayList<>(SelectorFragment.this.dataMap.keySet()));
            }
        };
    }

    public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> implements View.OnClickListener {
        private List<String> mTitles;
        private Context mContext;

        TitleAdapter(Context context, List<String> titleList) {
            this.mContext = context;
            this.mTitles = titleList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            TextView text = (TextView)holder.itemView.findViewById(android.R.id.text1);
            text.setText(mTitles.get(position));

            text.setTag(dataMap.get(mTitles.get(position)));
            text.setOnClickListener(this);
        }

        @Override
        public int getItemCount() {
            return mTitles == null ? 0 : mTitles.size();
        }

        @Override
        public void onClick(View view) {
            selected.postValue(view.getTag().toString());
        }

        void setTitles(List<String> titles) {
            mTitles.clear();
            mTitles.addAll(titles);
            notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }


    @Override
    public void onStop() {
        if(compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }

        super.onStop();
    }
}
