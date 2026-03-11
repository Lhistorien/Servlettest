package be.eafc.quentin.dto;

public class SearchResponse {
    private String name;
    private boolean exists;
    private String error;

    public SearchResponse() {}

    public SearchResponse(String name, boolean exists) {
        this.name = name;
        this.exists = exists;
    }

    public SearchResponse(String error) {
        this.error = error;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isExists() { return exists; }
    public void setExists(boolean exists) { this.exists = exists; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    @Override
    public String toString() {
        return "SearchResponse{name='" + name + "', exists=" + exists + "}";
    }
}

