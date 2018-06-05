package be.vdab.retrovideo.services;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Reservatie;

public interface ReservatiesService {
	void updateReservatiesEnFilms(Reservatie reservatie, Film film);
}
