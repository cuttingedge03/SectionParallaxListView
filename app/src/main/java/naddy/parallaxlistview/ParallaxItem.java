package naddy.parallaxlistview;

/**
 * Created by nadeemansari on 03/06/16.
 */

public class ParallaxItem extends AbstractItem {

    private String title;

    public ParallaxItem(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isSection() {
        return true;
    }
}
