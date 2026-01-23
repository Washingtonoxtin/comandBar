package com.oxtin.comandBar.repository;

import com.oxtin.comandBar.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
