package com.yola.aloysiuschow.topdownloads;

public class FeedEntry {

    private String title;
    private String pubDate;
    private String description;
    private String image;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "title=" + title + '\n' +
                ", publicationDate=" + pubDate + '\n' +
                ", description=" + description + '\n' +
                ", link=" + link + '\n' +
                '}';
    }
}
