package com.polstech.library.androidarchsamples.ui.quote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.databinding.LayoutQuoteElementBinding;

import java.util.List;

/**
 * Created by polprashant on 18/02/18.
 */

public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteRecyclerAdapter.QuoteViewHolder> {

    private Context mContext;
    private List<String> mQuoteList;

    public QuoteRecyclerAdapter(Context context, List<String> quoteList) {
        mContext = context;
        mQuoteList = quoteList;
        setHasStableIds(true);
    }

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutQuoteElementBinding binding = LayoutQuoteElementBinding.inflate(LayoutInflater.from(mContext), parent, false);

        return new QuoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder holder, int position) {
        holder.bind(mQuoteList.get(position));
    }


    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }

    public void setQuoteData(List<String> quotes) {
        mQuoteList.clear();
        mQuoteList.addAll(quotes);
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class QuoteViewHolder extends RecyclerView.ViewHolder {
        LayoutQuoteElementBinding binding;

        public QuoteViewHolder(LayoutQuoteElementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String text) {
            QuoteElementViewModel<QuoteActivity> viewModel = new QuoteElementViewModel<>();
            viewModel.text.set(text);

            binding.setQuoteElementVM(viewModel);
            binding.executePendingBindings();
        }
    }
}
