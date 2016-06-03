package naddy.parallaxlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by nadeemansari on 03/06/16.
 */

public class MainActivity extends AppCompatActivity {

    ParallaxRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create dummy data
        ArrayList<AbstractItem> itemArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AbstractItem item;

            if (i % 5 == 0) {
                item = new ParallaxItem("Row" + i);
            } else {
                item = new ListItem("Hey", "there");
            }
            itemArrayList.add(item);
        }

        // prepare the recyclerview
        recyclerView = (ParallaxRecyclerView) findViewById(R.id.recyclerview);

        // do the adapter
        ParallaxAdapter parallaxAdapter = new ParallaxAdapter(itemArrayList, this);

        // bind the adapter with the recyclerview
        recyclerView.setAdapter(parallaxAdapter);

    }
}
