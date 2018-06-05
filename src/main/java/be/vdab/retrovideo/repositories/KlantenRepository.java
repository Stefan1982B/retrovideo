package be.vdab.retrovideo.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;

public interface KlantenRepository {
	List<Klant> findByFamilienaamBevat(String deelNaam);
	Klant read(int id);
}
