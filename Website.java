import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Website implements Subject {
    private String url;
    private Document content;
    private List<Observer> observerList = new ArrayList<>();

    public Website(String url) throws IOException {
        this.url = url;
        this.content = Jsoup.connect(url).get();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Observer> getObserver() {
        return observerList;
    }

    public Document getNewContent() throws IOException {
        return Jsoup.connect(this.url).get();
    }

    public boolean websiteUpdate(int strategy) throws IOException {
        Document newContent = this.getNewContent();
        boolean updated = false;

        switch (strategy) {
            case 1:
                if (this.contentSize() != newContent.html().length()) {
                    updated = true;
                }
                break;
            case 2:
                if (!this.content.html().equals(newContent.html())) {
                    updated = true;
                }
                break;
            case 3:
                if (!this.textContent().equals(stripHtml(newContent.html()))) {
                    updated = true;
                }
                break;
        }

        if (updated) {
            this.content = newContent;
            this.notifyObservers();
            return true;
        }

        return false;
    }

    private int contentSize() {
        return this.content.html().length();
    }

    private String textContent() {
        return stripHtml(this.content.html());
    }

    private String stripHtml(String html) {
        Document doc = Jsoup.parse(html);
        return doc.text();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList) {
            o.update();
        }
    }
}
