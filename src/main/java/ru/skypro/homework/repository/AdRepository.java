package ru.skypro.homework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.model.ad.FullAd;


public interface AdRepository extends JpaRepository<Ad, Integer> {

    @Query(value = "SELECT * FROM ad WHERE author = ?1", nativeQuery = true)
    List<Ad> getAd(int authorId);

    @Query(value = "SELECT * FROM ad", nativeQuery = true)
    List<Ad> getAllAds();

    @Query(value = "SELECT * FROM ad WHERE ad.pk = ?1 LIMIT 1", nativeQuery = true)
    Ad getFullAd(int id);

    @Query(value = "SELECT image FROM ad WHERE ad.author = ?1", nativeQuery = true)
    List<String> getImages(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ad SET price = ?2, title = ?3, description = ?4 WHERE ad.pk = ?1", nativeQuery = true)
    void updateAd(int id, int price, String title, String description);

    @Query(value = "SELECT image FROM ad WHERE ad.pk = ?1", nativeQuery = true)
    List<String> getImage(int id);
    

}
