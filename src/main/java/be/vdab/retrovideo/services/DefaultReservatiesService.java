package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;

import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.repositories.ReservatiesRepository;

@Service
class DefaultReservatiesService implements ReservatiesService {
	
	private final ReservatiesRepository repository;
	
	DefaultReservatiesService(ReservatiesRepository repository){
		this.repository = repository;
	}

	@Override
	public void create(Reservatie reservatie) {
		repository.create(reservatie);
		
	}

}
