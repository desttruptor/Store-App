package com.example.storeapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.storeapp.R;
import com.example.storeapp.databinding.AppListItemBinding;
import com.example.storeapp.domain.models.AppsListItemModel;
import com.example.storeapp.utils.CustomConsumer;

import java.util.Collections;
import java.util.List;

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.AppsListViewHolder> {

    @NonNull
    private final CustomConsumer<String> onItemClickCallback;
    @NonNull
    private List<AppsListItemModel> displayedList = Collections.emptyList();

    public AppsListAdapter (
            @NonNull CustomConsumer<String> onItemClickCallback
    ) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public AppsListViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        var view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list_item, parent, false);
        return new AppsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull AppsListViewHolder holder, int position) {
        holder.bind(displayedList.get(position));
    }

    @Override
    public int getItemCount () {
        return displayedList.size();
    }

    public void submitNewList (List<AppsListItemModel> newList) {
        var callback = DiffUtil.calculateDiff(new AppsListDiffUtilCallback(displayedList, newList));
        displayedList = newList;
        callback.dispatchUpdatesTo(this);
    }

    private static class AppsListDiffUtilCallback extends DiffUtil.Callback {

        @NonNull
        private final List<AppsListItemModel> oldList;
        @NonNull
        private final List<AppsListItemModel> newList;

        public AppsListDiffUtilCallback (
                @NonNull List<AppsListItemModel> oldList,
                @NonNull List<AppsListItemModel> newList
        ) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize () {
            return oldList.size();
        }

        @Override
        public int getNewListSize () {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame (int oldItemPosition, int newItemPosition) {
            return oldList.get(oldItemPosition).getTitle()
                    .equals(newList.get(newItemPosition).getTitle());
        }

        @Override
        public boolean areContentsTheSame (int oldItemPosition, int newItemPosition) {
            return oldList.get(oldItemPosition).getTitle()
                    .equals(newList.get(newItemPosition).getTitle());
        }
    }

    public class AppsListViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final AppListItemBinding binding;
        @NonNull
        private final RequestOptions requestOptions;

        public AppsListViewHolder (@NonNull View itemView) {
            super(itemView);
            binding = AppListItemBinding.bind(itemView);
            requestOptions = new RequestOptions()
                    .circleCrop()
                    .placeholder(R.drawable.ic_outline_get_app_24);
        }

        public void bind (AppsListItemModel model) {
            binding.getRoot().setOnClickListener((view) -> {
                onItemClickCallback.accept(model.getTitle());
            });
            binding.chipStatus.setText(model.getStatus());
            binding.tvAppName.setText(model.getTitle());
            Glide.with(itemView.getContext())
                    .load(model.getLogo200Link())
                    .apply(requestOptions)
                    .into(binding.ivAppLogo);
        }
    }
}
