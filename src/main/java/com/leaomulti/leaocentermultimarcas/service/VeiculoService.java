package com.leaomulti.leaocentermultimarcas.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leaomulti.leaocentermultimarcas.exception.CadastroVeicularException;
import com.leaomulti.leaocentermultimarcas.model.Veiculo;
import com.leaomulti.leaocentermultimarcas.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	private void validateFuel(String fuel) {
		List<String> validFuel = Arrays.asList("gasolina", "alcool", "diesel", "eletrico");
		if(!validFuel.contains(fuel.toLowerCase())) {
			throw new CadastroVeicularException.InvalidFuelException();
		}
	}
	
	public Veiculo cadastrarVeiculo(Veiculo veiculo) {
		if(veiculo.getMarca().isEmpty() || 
		   veiculo.getNome().isEmpty() || 
		   veiculo.getCor().isEmpty() ||
		   veiculo.getCombustivel().isEmpty() ||
		   veiculo.getFinalPlaca().isEmpty()) {
			throw new CadastroVeicularException.BlankFieldException();
		}
		
		if(veiculo.getAnoModelo() <= 0 || veiculo.getAnoFabricacao() <= 0) {
			throw new CadastroVeicularException.BlankFieldException();
		}
		
		if(veiculo.getAnoModelo() <= 1979) {
			throw new CadastroVeicularException.InvalidYearModelException();
		}
		
		if(veiculo.getValor() <= 0) {
			throw new CadastroVeicularException.BlankFieldException();
		}
		
		validateFuel(veiculo.getCombustivel());
		
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> getAllVehicles() {
		return veiculoRepository.findAll();
	}
	
	public Optional<Veiculo> getVehicleById(Long id) {
		return veiculoRepository.findById(id);
	}
	
	public Veiculo updateVeiculo(Long id, Veiculo veiculo) {
		veiculo.setId(id);
		return veiculoRepository.save(veiculo);
	}
	
	public void deleteVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}
}
