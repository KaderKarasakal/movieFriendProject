package com.sistersLab.movieFriend.service;

import com.sistersLab.movieFriend.dto.CinephileDto;

import com.sistersLab.movieFriend.model.Cinephile;

import com.sistersLab.movieFriend.repository.CinephileRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
@Slf4j
@Getter
@Setter
public class CinephileService {
    private final CinephileRepository cinephileRepository;


    public CinephileDto createCinephile(CinephileDto cinephileDto) {
        Cinephile cinephile = new Cinephile();
        cinephile.setName(cinephileDto.getName());
        cinephile.setEmail(cinephileDto.getEmail());
        cinephile.setSurname(cinephileDto.getSurname());
        cinephile.setPassword(cinephile.getPassword());
        cinephile = cinephileRepository.save(cinephile);
        return convertToDto(cinephile);
    }



    public CinephileDto getCinephile(Long id) {
        Cinephile cinephile = cinephileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinephile not found with id: " + id));
        return convertToDto(cinephile);
    }



    public CinephileDto updateCinephile(Long id, CinephileDto cinephileDto) {
        Cinephile cinephile = cinephileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinephile not found with id: " + id));
        cinephile.setName(cinephileDto.getName());
        cinephile.setEmail(cinephileDto.getEmail());
        cinephile.setSurname(cinephileDto.getSurname());
        cinephile.setPassword(cinephile.getPassword());
        cinephile = cinephileRepository.save(cinephile);
        return convertToDto(cinephile);
    }




    public void deleteCinephile(Long id) {
        if (!cinephileRepository.existsById(id)) {
            throw new RuntimeException("Cinephile not found with id: " + id);
        }
        cinephileRepository.deleteById(id);
    }


    private CinephileDto convertToDto(Cinephile cinephile) {
        CinephileDto cinephileDto = new CinephileDto();
        cinephileDto.setId(cinephile.getId());
        cinephileDto.setName(cinephile.getName());
        cinephileDto.setEmail(cinephile.getEmail());
        cinephileDto.setSurname(cinephile.getSurname());
        return cinephileDto;
    }


}