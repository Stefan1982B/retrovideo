package be.vdab.retrovideo.web;

import java.util.List;

import be.vdab.retrovideo.entities.Films;

interface Mandje {
  void addFilmId(int filmid);  
  public List<Integer> getFilmIds(); 
  void verwijder(int[] ids);
}
