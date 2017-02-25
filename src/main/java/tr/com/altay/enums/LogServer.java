package tr.com.altay.enums;

/**
 * Created by mustafa.ergan on 23.02.2017.
 */
public enum LogServer {
    SEQ(1,"http://10.6.250.127:5341/api/events/raw");

    private final int value;
    private final String text;

    LogServer(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue(){ return value;}

    public String getText(){ return text;}



}
