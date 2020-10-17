package com.example.swapi;

public class Film {

    String title;
    String crawl;
    String director;
    String producer;
    String releaseDate;

    public Film(String title,String crawl,String director,String producer,String releaseDate ){
        this.title = title;
        this.crawl = crawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getCrawl() {
        return crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Crawl: " + crawl.substring(0, crawl.replace("\\r\\n", "").indexOf(".")) + '\n' + //limiting the crawl to the first sentence to minimize screen usage
                "Director: " + director + '\n' +
                "Producer: " + producer + '\n' +
                "Release Date: " + releaseDate + '\n';
    }
}
