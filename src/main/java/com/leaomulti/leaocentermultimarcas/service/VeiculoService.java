package com.leaomulti.leaocentermultimarcas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leaomulti.leaocentermultimarcas.model.Veiculo;
import com.leaomulti.leaocentermultimarcas.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	public Veiculo cadastrarVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> getAllVehicles() {
		return veiculoRepository.findAll();
	}
	
	public Optional<Veiculo> getVehicleById(Long id) {
		return veiculoRepository.findById(id);
	}
	
	public Veiculo updateVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public void deleteVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}
}
