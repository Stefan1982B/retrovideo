package be.vdab.retrovideo.repositories;

import java.util.List;

import be.vdab.retrovideo.entities.Klant;

public interface KlantenRepository {
	List<Klant> findByFamilienaamBevat(String deelNaam);
}
