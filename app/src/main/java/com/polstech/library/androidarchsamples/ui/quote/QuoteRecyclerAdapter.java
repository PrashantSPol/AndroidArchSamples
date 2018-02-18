package com.polstech.library.androidarchsamples.ui.quote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.polstech.library.androidarchsamples.R;

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
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_quote_element, null, false);

        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder holder, int position) {
        Log.i("CHECK_", "position is " + position);
        holder.txtData.setText(mQuoteList.get(position));
    }


    @Override
    public int getItemCount() {
        Log.i("CHECK_", "count is " + mQuoteList.size());
        return mQuoteList.size();
    }

    public void setQuoteData(List<String> quotes) {
        Log.i("CHECK_", "Quote data is " + quotes);
        mQuoteList.clear();
        mQuoteList.addAll(quotes);
        notifyDataSetChanged();
    }

    static class QuoteViewHolder extends RecyclerView.ViewHolder {
        public TextView txtData;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            txtData = itemView.findViewById(R.id.txt_data);
        }
    }
}
