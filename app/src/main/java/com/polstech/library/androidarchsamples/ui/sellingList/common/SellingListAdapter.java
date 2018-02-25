package com.polstech.library.androidarchsamples.ui.sellingList.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.polstech.library.androidarchsamples.databinding.LayoutProductListBinding;

import java.util.List;

/**
 * Created by prashant.pol on 2/23/2018.
 */

public class SellingListAdapter extends RecyclerView.Adapter<SellingListAdapter.SellingListViewHolder> {

    Context context;
    List<Product> productList;

    public SellingListAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public SellingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutProductListBinding binding = LayoutProductListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SellingListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(SellingListViewHolder holder, int position) {
        Product product = productList.get(position);
        SellingListElementViewModel sellingListElementViewModel = new SellingListElementViewModel();
        sellingListElementViewModel.setProduct(product);

        holder.bind(sellingListElementViewModel);
    }

    public void setProducts(List<Product> productList) {
        this.productList.clear();
        this.productList.addAll(productList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    static class SellingListViewHolder extends RecyclerView.ViewHolder {

        LayoutProductListBinding binding;

        SellingListViewHolder(LayoutProductListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SellingListElementViewModel viewModel) {
            binding.setSellingListElementVM(viewModel);
            binding.executePendingBindings();
        }
    }
}
