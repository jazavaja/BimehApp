package com.javad.mrbimeh.Model;

public class ModelMessage {
    private String body;
    private String pic;
    private String time;
    private String title;

    public String getBody() {
        return this.body;
    }

    public String getPic() {
        return this.pic;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTime() {
        return this.time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
