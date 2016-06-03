package naddy.parallaxlistview;

/**
 * Created by nadeemansari on 03/06/16.
 */
public class AbstractItem implements Item {
    @Override
    public boolean isSection() {
        return false;
    }

    @Override
    public String getTitle() {
        return "Error";
    }

    @Override
    public String getSubtitle() {
        return "Error";
    }
}
