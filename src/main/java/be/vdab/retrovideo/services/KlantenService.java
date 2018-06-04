package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.entities.Klant;

public interface KlantenService {
	List<Klant> findByFamilienaamBevat(String deelNaam);
}
