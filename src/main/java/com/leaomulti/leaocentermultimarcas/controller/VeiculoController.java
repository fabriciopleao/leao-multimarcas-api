package com.leaomulti.leaocentermultimarcas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaomulti.leaocentermultimarcas.model.Veiculo;
import com.leaomulti.leaocentermultimarcas.service.VeiculoService;

@RestController
@RequestMapping("/api/leao-center")
public class VeiculoController {

	private final VeiculoService veiculoService;
	
	@Autowired
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	@GetMapping("/catalogo")
	public ResponseEntity<List<Veiculo>> listarVeiculos() {
		List<Veiculo> veiculos = veiculoService.getAllVehicles();
		return new ResponseEntity<>(veiculos, HttpStatus.OK);
	
	}
	
	@GetMapping("/catalogo/{id}")
	public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
		Optional<Veiculo> veiculoOptional = veiculoService.getVehicleById(id);
		if(veiculoOptional.isPresent()) {
			return new ResponseEntity<>(veiculoOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo veiculoCadastrado = veiculoService.cadastrarVeiculo(veiculo);
		return new ResponseEntity<>(veiculoCadastrado, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		Veiculo veiculoAtualizado = veiculoService.updateVeiculo(id, veiculo);
		return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Veiculo> excluirVeiculo(@PathVariable Long id) {
		veiculoService.deleteVeiculo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
