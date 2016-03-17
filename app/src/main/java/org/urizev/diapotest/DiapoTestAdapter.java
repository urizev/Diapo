package org.urizev.diapotest;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

/**
 * Created by jcvallejo at 9/3/16.
 */
public class DiapoTestAdapter extends RecyclerView.Adapter<DiapoTestAdapter.DiapoTestViewHolder> {

    private final WeakReference<DiapoTestAdapterListener> listener;

    public DiapoTestAdapter(DiapoTestAdapterListener listener) {
        this.listener = new WeakReference<>(listener);
    }

    @Override
    public DiapoTestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiapoTestViewHolder (parent);
    }

    @Override
    public void onBindViewHolder(DiapoTestViewHolder holder, int position) {
        holder.update(Data.IMAGE_URLS.get(position));
    }

    @Override
    public int getItemCount() {
        return Data.IMAGE_URLS.size();
    }

    public class DiapoTestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImage;
        private String mLink;

        public DiapoTestViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_image, parent, false));
            this.mImage = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        public void update (String link) {
            this.mLink = link;
            Picasso.with(itemView.getContext())
                    .load(link)
                    .config(Bitmap.Config.RGB_565)
                    .placeholder(R.color.colorPlaceholder)
                    .error(R.color.colorPlaceholder)
                    .into(mImage);
        }

        @Override
        public void onClick(View v) {
            DiapoTestAdapterListener l = listener.get();
            if (l != null) {
                l.onImageClicked(mLink);
            }
        }
    }

    public interface DiapoTestAdapterListener {
        void onImageClicked(String link);
    }
}
