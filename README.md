# Department Of Human Services

Departman, çalışan ve rol kayıtlarını JSON olarak dönen küçük bir Spring MVC + Hibernate REST servisi.

> **Not:** Bu depo 2017 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

- `tr.com.altay.Entity` — `Departmant`, `Employee`, `Role` varlıkları
- `tr.com.altay.dao` ve `tr.com.altay.service` — Hibernate tabanlı DAO ve servis katmanı
- `tr.com.altay.restcontroller` — REST uçları:
  - `GET /info/`
  - `GET /departmant/`, `GET /departmant/{id}`
  - `GET /employee/`, `GET /employee/{id}`, `GET /employee/departmant/{id}`
- `tr.com.altay.configuration` — `web.xml` kullanmadan Java tabanlı Spring MVC ve Hibernate ayarları
- `src/main/java/resources/hibernate.properties` — veritabanı bağlantı ayarları

## Teknolojiler

- Java, Maven (`war` paketleme)
- Spring Framework 4.3.0 (Web MVC, ORM, TX)
- Hibernate 4.3.11
- Gson 2.8.0, Logback 1.1.7
- PostgreSQL JDBC sürücüsü (9.3); `pom.xml` içinde Oracle `ojdbc6` bağımlılığı da var

## Veritabanı

Uygulama `DEPARTMANT`, `EMPLOYEE` ve `ROLE` tablolarını kullanır. Eski README'deki Oracle şeması:

```sql
CREATE TABLE "PROJE"."DEPARTMANT"
(   "ID" NUMBER NOT NULL ENABLE,
    "NAME" VARCHAR2(100 BYTE),
    CONSTRAINT "DEPARTMAN_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "PROJE"."EMPLOYEE"
(   "ID" NUMBER,
    "NAME" VARCHAR2(20 BYTE),
    "ROLE_ID" NUMBER,
    "DEPARTMAN_ID" NUMBER
);

CREATE TABLE "PROJE"."ROLE"
(   "ID" NUMBER NOT NULL ENABLE,
    "ROLE" VARCHAR2(20 BYTE),
    CONSTRAINT "ROLE_PK" PRIMARY KEY ("ID")
);
```

(Asıl betikteki tablespace ve depolama ayarları kısaltıldı.) `hibernate.properties` ise PostgreSQL'e göre ayarlı ve
`hibernate.hbm2ddl.auto = update` olduğu için tablolar Hibernate tarafından da oluşturulabilir.

## Çalıştırma

1. Bir PostgreSQL veritabanı hazırlayın.
2. `hibernate.properties` içindeki adres, kullanıcı adı ve şifreyi kendi değerlerinizle doldurun; şifre alanı
   `SIFRE_KALDIRILDI` olarak bırakılmıştır.
3. `mvn package` ile `target/ALTAY.war` dosyasını üretip Tomcat gibi bir servlet konteynerine kurun.

Bilinen sorunlar: `ojdbc6` Maven Central'da bulunmaz, derleme bu bağımlılıkta takılırsa onu yerel depoya elle
kurmanız ya da `pom.xml`'den çıkarmanız gerekir. Ayar dosyası standart dışı olarak `src/main/java/resources/`
altında durduğu için Maven onu sınıf yoluna kopyalamayabilir; gerekirse `src/main/resources/` altına taşıyın.
