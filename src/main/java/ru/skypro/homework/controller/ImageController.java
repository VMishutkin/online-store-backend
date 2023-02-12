package ru.skypro.homework.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.service.ads.AdsService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final Logger logger = LoggerFactory.getLogger(ImageController.class);
    private final AdsService adsService;


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getAdsImage(@PathVariable(value = "id") Integer id) {
        byte[] picture = adsService.getImage(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(picture.length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(picture);
    }

    @PatchMapping(value = "/{id}", consumes = "multipart/form-data")
    public String updateAdsImage(@PathVariable(value = "id") Integer id,
                                 @RequestPart(value = "image") MultipartFile file,
                                 Authentication authentication) {
        logger.info("ImageController. method updateAdsImage. Username = " + authentication);
        return adsService.updateImage(id, file);
    }

}
