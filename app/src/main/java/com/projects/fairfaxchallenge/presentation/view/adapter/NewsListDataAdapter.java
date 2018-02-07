package com.projects.fairfaxchallenge.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projects.fairfaxchallenge.MainApplication;
import com.projects.fairfaxchallenge.R;
import com.projects.fairfaxchallenge.domain.model.Asset;
import com.projects.fairfaxchallenge.domain.model.RelatedImage;
import com.projects.fairfaxchallenge.presentation.events.EventFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Adapter that manages a Collection of {@link Asset}
 */
public class NewsListDataAdapter extends RecyclerView.Adapter<NewsListDataAdapter.NewsSingleItemHolder> {

    private List<Asset> assetItemList;
    private Context mContext;
    private static final String TAG = NewsListDataAdapter.class.getSimpleName();
    private final int SMALLER_RELATED_IMAGE = 0;

    public NewsListDataAdapter(Context context, ArrayList<Asset> assetItemList) {
        this.assetItemList = assetItemList;
        mContext = context;
    }

    @Override
    public NewsSingleItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_single, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new NewsSingleItemHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsSingleItemHolder holder, final int position) {
        // Set up Headline, Abstract and Author
        holder.tvHeadLine.setText(assetItemList.get(position).getHeadline());
        holder.tvAbstract.setText(assetItemList.get(position).getTheAbstract());
        holder.tvByLine.setText(assetItemList.get(position).getByLine());
        List<RelatedImage> relatedImages = assetItemList.get(position).getRelatedImages();
        if (null != relatedImages) {
            Collections.sort(relatedImages, new Comparator<RelatedImage>() {
                @Override
                public int compare(RelatedImage o1, RelatedImage o2) {
                    return o1.getWidth().compareTo(o2.getWidth());
                }
            });
            Log.d(TAG, "The headline is " + assetItemList.get(position).getHeadline() + " and the width " +
                    "is " + relatedImages.get(0).getWidth() + " and height is " + relatedImages.get(0).getHeight());
            Glide.with(mContext)
                    .load(relatedImages.get(SMALLER_RELATED_IMAGE).getUrl())
                    .centerCrop()
                    .into(holder.ivRelatedImage);

        } else { // replace with default news image
            Glide.with(mContext)
                    .load(R.mipmap.afr_logo)
                    .centerCrop()
                    .into(holder.ivRelatedImage);
        }
        // Open the Web View on News Item Click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainApplication.get().bus().post(new EventFragment(assetItemList.get(position)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != assetItemList ? assetItemList.size() : 0);
    }

    public class NewsSingleItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.headLine)
        TextView tvHeadLine;

        @BindView(R.id.description)
        TextView tvAbstract;

        @BindView(R.id.author)
        TextView tvByLine;

        @BindView(R.id.relatedImage)
        ImageView ivRelatedImage;


        public NewsSingleItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
