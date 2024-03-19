package denisson.springdatajpa.ropository;

import org.springframework.data.jpa.repository.JpaRepository;

import denisson.springdatajpa.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
