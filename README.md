####Movie Friend Project####
Movie Friend Project, Spring Boot kullanarak temel CRUD (Create, Read, Update, Delete) işlemlerini kapsayan bir platformdur. Ayrıca ilişkisel veritabanı yönetimi ve RESTful web servisleri konularında deneyim kazandırmaktadır.
Movie Friend (film arkadaşı) projesi ile kullanıcı ve film arasındaki etkileşimin etkili bir şekilde yönetimi amaçlanmıştır.

#Kullanılan Teknolojiler:
Spring Boot, Spring Framework üzerine inşa edilmiş, hızlı ve kolay bir şekilde geliştirme imkanı sağlayan bir Java kütüphanesidir.
H2, kurulum gerektirmez. Geliştirme ve test ortamları için idealdir. Çünkü kolayca sıfırlanabilir ve dağıtılabilir. 
REST API, farklı sistemler arasında bilgi alışverişini sağlar.
Postman, geliştiricilere API istekleri gönderme, yanıtları alıp inceleme, otomasyon testleri yazma ve API'ların belgelendirilmesi gibi işlemleri kolaylaştırır.
Eklenen kütüphaneler: spring web, spring data jpa, lombok, h2

#Yönetim:
Kullanıcı Yönetimi: kullanıcı kaydı, listeleme, güncelleme ve silme işlemleri.
Film Yönetimi: Filmlerin listelenmesi, yeni film ekleme, mevcut film güncelleme ve silme işlemleri.
İzleme Listesi (Watchlist): Kullanıcıların izleme listelerine film ekleyebilmesi, listeden film çıkarabilmesi. Bu, Many-to-Many ilişkisi(@ManyToMany ve @JoinTable anotasyonları) ile yönetilmiştir.
DTO (Data Transfer Object) kullanarak, istemciye gönderilecek verilerin yönetimini kolaylaştırıldı.








