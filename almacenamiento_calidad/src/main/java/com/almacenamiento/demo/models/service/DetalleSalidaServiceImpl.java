package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.DetalleSalida;
import com.almacenamiento.demo.models.repository.DetalleSalidaRepository;

@Service
public class DetalleSalidaServiceImpl implements IDetalleSalidaService {

	@Autowired
	private DetalleSalidaRepository detalleSalidaRepository;
	@Override
	public List<DetalleSalida> listarDetalleSalida() {
		return (List<DetalleSalida>) detalleSalidaRepository.findAll();
	}

	@Override
	public void guardar(DetalleSalida detalleSalida) {
		detalleSalidaRepository.save(detalleSalida);
		
	}

	@Override
	public DetalleSalida buscarDetalleSalida(Long id) {
		return detalleSalidaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		detalleSalidaRepository.deleteById(id);
		
	}

}
