package be.vdab.retrovideo.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

interface Mandje {
  void addFilmId(int filmid);  
  List<Integer> getFilmIds(); 
  void verwijder(int[] ids);
  BigDecimal berekenTotalePrijs(List<BigDecimal> filmPrijzen);
}
