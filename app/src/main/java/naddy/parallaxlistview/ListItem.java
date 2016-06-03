package naddy.parallaxlistview;

/**
 * Created by nadeemansari on 03/06/16.
 */
public class ListItem extends AbstractItem {

    public final String title;
    public final String subtitle;

    public ListItem(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public boolean isSection() {
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }
}
