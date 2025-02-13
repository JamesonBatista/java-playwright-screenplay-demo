package screen;

public class NavigateTo implements Task {
    private final String url;

    private NavigateTo(String url) {
        this.url = url;
    }

    public static NavigateTo theUrl(String url) {
        return new NavigateTo(url);
    }

    @Override
    public void performAs(Actor actor) {
        actor.getPage().navigate(url);
    }
}