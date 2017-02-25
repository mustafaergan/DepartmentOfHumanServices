package tr.com.altay.enums;

/**
 * Created by mustafa.ergan on 10.11.2016.
 */
public enum LdapConfEnum {
    ADMIN_USER(1,"adsap"),
    ADMIN_PASS(2,"yD4!56vLGz"),
    LDAP_URL(3,"LDAP://edchqdcx04.altay.local"),
    LDAP_SEARCH_BASE(4,"ou=EDAS,dc=altay,dc=local"),
    OBJECT_CLASS(5,"(objectClass=user)"),
    OBJECT_CATEGORY(6,"(objectCategory=person)"),
    ACTIVE_USER(7,"(!(userAccountControl:1.2.840.113556.1.4.803:=2))"),
    DC(8,"@ENERJISA");


    private final int value;
    private final String text;

    LdapConfEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue(){ return value;}

    public String getText(){ return text;}

}
