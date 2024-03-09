package com.sistersLab.movieFriend.controller;

import com.sistersLab.movieFriend.dto.CinephileDto;



import com.sistersLab.movieFriend.service.CinephileService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cinephiles")

public class CinephileController {
    private final CinephileService cinephileService;
    @PostMapping
    public ResponseEntity<CinephileDto> createCinephile(@RequestBody CinephileDto cinephileDto) {
        CinephileDto newCinephileDto = cinephileService.createCinephile(cinephileDto);
        return new ResponseEntity<>(newCinephileDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CinephileDto> getCinephile(@PathVariable Long id) {
        CinephileDto cinephileDto = cinephileService.getCinephile(id);
        return ResponseEntity.ok(cinephileDto);
    }
    // Kullanıcı Bilgilerini Güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<CinephileDto> updateCinephile(@PathVariable Long id, @RequestBody CinephileDto cinephileDto) {
        CinephileDto updatedCinephileDto = cinephileService.updateCinephile(id, cinephileDto);
        return ResponseEntity.ok(updatedCinephileDto);
    }

    // Kullanıcıyı Silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCinephile(@PathVariable Long id) {
        cinephileService.deleteCinephile(id);
        return ResponseEntity.noContent().build();
    }



}



