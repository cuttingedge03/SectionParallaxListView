package naddy.parallaxlistview;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nadeemansari on 03/06/16.
 */

public class ParallaxAdapter extends RecyclerView.Adapter<ParallaxAdapter.ParallaxViewHolder> {

    private List<AbstractItem> parallaxItemList;
    private Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_CHILD = 1;

    public ParallaxAdapter(List<AbstractItem> parallaxItemList, Context context) {
        this.parallaxItemList = parallaxItemList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 5 == 0)
            return TYPE_HEADER;
        else
            return TYPE_CHILD;

    }

    @Override
    public ParallaxViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view;

        int listViewItemType = getItemViewType(type);
        ParallaxViewHolder parallaxViewHolder = null;

        switch (listViewItemType) {
            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_parallax, parent,
                        false);
                parallaxViewHolder = new ParallaxViewHolder(view, TYPE_HEADER);
                break;
            case TYPE_CHILD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,
                        false);
                parallaxViewHolder = new ParallaxViewHolder(view, TYPE_CHILD);
                break;
        }
        return parallaxViewHolder;
    }


    @Override
    public void onBindViewHolder(ParallaxViewHolder parallaxViewHolder, int position) {

        AbstractItem item = parallaxItemList.get(position);

        switch (parallaxViewHolder.getItemViewType()) {
            case TYPE_HEADER:
//                parallaxViewHolder.parallaxImage.setImageResource(R.drawable.image);
                Picasso.with(context).load(R.drawable.image).into(parallaxViewHolder.parallaxImage);
                parallaxViewHolder.parallaxText.setText(item.getTitle());
                Matrix matrix = parallaxViewHolder.parallaxImage.getImageMatrix();
                matrix.postTranslate(0, -150);
                parallaxViewHolder.parallaxImage.setImageMatrix(matrix);
                parallaxViewHolder.itemView.setTag(parallaxViewHolder);
                break;
            case TYPE_CHILD:
                parallaxViewHolder.t1.setText(item.getTitle());
                parallaxViewHolder.t2.setText(item.getSubtitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        // hardcoded first
        return parallaxItemList.size();
    }

    @Override
    public void onViewRecycled(ParallaxViewHolder parallaxViewHolder) {
        super.onViewRecycled(parallaxViewHolder);
        switch (parallaxViewHolder.getItemViewType()) {
            case TYPE_HEADER:
                parallaxViewHolder.parallaxImage.setScaleType(ImageView.ScaleType.MATRIX);
                Matrix matrix = parallaxViewHolder.parallaxImage.getImageMatrix();
                // this is set manually to show center
                matrix.reset();
                parallaxViewHolder.parallaxImage.setImageMatrix(matrix);
                break;
            case TYPE_CHILD:
                // Nothing to do
                break;
        }

    }

    public static class ParallaxViewHolder extends RecyclerView.ViewHolder {

        ImageView parallaxImage;
        TextView parallaxText;
        TextView t1;
        TextView t2;

        public ParallaxViewHolder(View itemView, int type) {
            super(itemView);
            switch (type) {
                case TYPE_HEADER:
                    parallaxImage = (ImageView) itemView.findViewById(R.id.image_background);
                    parallaxImage.setScaleType(ImageView.ScaleType.MATRIX);
                    parallaxText = (TextView) itemView.findViewById(R.id.text_title);
                    break;
                case TYPE_CHILD:
                    t1 = (TextView) itemView.findViewById(R.id.list_item_entry_title);
                    t2 = (TextView) itemView.findViewById(R.id.list_item_entry_summary);
                    break;
            }
        }
    }
}
