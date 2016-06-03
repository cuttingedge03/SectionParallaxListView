package naddy.parallaxlistview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by nadeemansari on 03/06/16.
 */

public class ParallaxRecyclerView extends RecyclerView {

    public ParallaxRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public ParallaxRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ParallaxRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }


    void init(Context context) {
        setLayoutManager(new LinearLayoutManager(context));
        addOnScrollListener(new ParallaxScrollListener());
    }

}
