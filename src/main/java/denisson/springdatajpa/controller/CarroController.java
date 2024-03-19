package denisson.springdatajpa.controller;

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
import org.springframework.web.bind.annotation.RestController;

import denisson.springdatajpa.model.Carro;
import denisson.springdatajpa.ropository.CarroRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarroController {
    
    @Autowired
    CarroRepository carroRepository;

    @PostMapping("/carros")
    public ResponseEntity<?> saveCarro(@RequestBody Carro carro) {
        if (carro == null) {
            return ResponseEntity.badRequest().body("Carro não pode ser nullo");
        }

        return ResponseEntity.ok(carroRepository.save(carro));
    }

    @GetMapping("/carros")
    public List<Carro> getAllCars() {
        return carroRepository.findAll();
    }

    @GetMapping("/carros/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Id do carro não pode ser nulo!");
        }

        Optional<Carro> optionalCarro = carroRepository.findById(id);
        if ( (optionalCarro.isPresent())) {
            return ResponseEntity.ok(optionalCarro.get());
        } 
        return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Carro não encontrado!");
    }

    @DeleteMapping("/carros/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Digite um Id válido!");
        }

        Optional<Carro> optionalCarro = carroRepository.findById(id);
        if (optionalCarro.isPresent()) {
            carroRepository.deleteById(id);
        }
        return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Carro não encontrado!");
    }

    @PutMapping("/carros/{id}")
    public ResponseEntity<?> updateCarById(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Id do carro não pode ser nulo!");
        }

        Optional<Carro> optionalCarro = carroRepository.findById(id);
        if(optionalCarro.isPresent()) {
            Carro carroExistente = optionalCarro.get();
            carroExistente.setAno(carroAtualizado.getAno());
            carroExistente.setCor(carroAtualizado.getCor());
            carroExistente.setDescricao(carroAtualizado.getDescricao());
            carroExistente.setId(carroAtualizado.getId());
            carroExistente.setImagem(carroAtualizado.getImagem());
            carroExistente.setKilometragem(carroAtualizado.getKilometragem());
            carroExistente.setMarca(carroAtualizado.getMarca());
            carroExistente.setModelo(carroAtualizado.getModelo());
            carroExistente.setMotor(carroAtualizado.getMotor());
            carroExistente.setPreco(carroAtualizado.getPreco());
            carroExistente.setTipo(carroAtualizado.getTipo());
            carroExistente.setTransmissao(carroAtualizado.getTransmissao());

            Carro carroAtualizadoSalvo = carroRepository.save(carroExistente);
            return ResponseEntity.ok(carroAtualizadoSalvo);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
    }
}
