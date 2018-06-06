package be.vdab.retrovideo.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import be.vdab.retrovideo.entities.TotalePrijs;

interface Mandje {
  void addFilmId(int filmid);  
  Set<Integer> getFilmIds(); 
  void verwijder(int[] ids);
  TotalePrijs berekenTotalePrijs(List<BigDecimal> filmPrijzen);
}
