package com.sistersLab.movieFriend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class WatchlistDto {
    private Long cinephileId;
    private String cinephileName;
    private String cinephileSurname;
    private Set<Long> movieIds;// ekleme- cıkarma işlemleri için
    private Set<String> movieName;
    private Set<String> note;
    private Set<Boolean> watchedStatus;
}
