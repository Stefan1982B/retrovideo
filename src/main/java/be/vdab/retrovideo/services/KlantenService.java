package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Klant;

public interface KlantenService {
	List<Klant> findByFamilienaamBevat(String deelNaam);
	Klant read(int id);
}
