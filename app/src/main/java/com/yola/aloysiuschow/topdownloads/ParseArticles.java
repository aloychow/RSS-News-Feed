package com.yola.aloysiuschow.topdownloads;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseArticles {

    private static final String TAG = "ParseArticles";
    private ArrayList<FeedEntry> articles;

    public ParseArticles() {
        this.articles = new ArrayList<>();
    }

    public ArrayList<FeedEntry> getArticles() {
        return articles;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        FeedEntry currentRecord = null;
        boolean inEntry = false;
        String textValue = "";
        String link;

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
//                        Log.d(TAG, "parse: Starting tag for " + tagName);
                        if("item".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentRecord = new FeedEntry();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
//                        Log.d(TAG, "parse: Ending tag for " + tagName);
                        if(inEntry) {
                            if("item".equalsIgnoreCase(tagName)) {
                                articles.add(currentRecord);
                                inEntry = false;
                            } else if("title".equalsIgnoreCase(tagName)) {
                                currentRecord.setTitle(textValue);
                            } else if("pubdate".equalsIgnoreCase(tagName)) {
                                currentRecord.setPubDate(textValue);
                            } else if("description".equalsIgnoreCase(tagName)) {
                                currentRecord.setDescription(textValue);
                            } else if("link".equalsIgnoreCase(tagName)) {
                                currentRecord.setLink(textValue);
                                link = textValue;
                            }
                        }
                        break;

                    default:
                        // Nothing else to do.
                }
                eventType = xpp.next();

            }
//            for (FeedEntry art: articles) {
//                Log.d(TAG, "******************");
//                Log.d(TAG, art.toString());
//            }

        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }

}