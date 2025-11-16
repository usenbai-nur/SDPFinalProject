package adapter;

public class ExternalNews {
    private final String kind;
    private final String heading;
    private final String body;
    public ExternalNews(String kind, String heading, String body) { this.kind = kind; this.heading = heading; this.body = body; }
    public String getKind() { return kind; }
    public String getHeading() { return heading; }
    public String getBody() { return body; }
}
