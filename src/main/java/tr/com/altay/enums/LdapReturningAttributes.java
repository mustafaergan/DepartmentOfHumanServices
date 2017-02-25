package tr.com.altay.enums;

/**
 * Created by mustafa.ergan on 10.11.2016.
 */
public enum LdapReturningAttributes {
    DISPLAYNAME(1,"displayname"),
    DEPARTMANT(2,"department"),
    COMPANY(3,"company"),
    MAIL(4,"mail");

    private final int value;
    private final String text;

    LdapReturningAttributes(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static String[] allAttributes() {
        LdapReturningAttributes[] att = values();

        String[] names = new String[att.length];

        for (int i = 0; i < att.length; i++) {
            names[i] = att[i].getText();
        }

        return names;
    }

    public int getValue(){ return value;}

    public String getText(){ return text;}
}
