package com.fiap.produto.repository;

import com.fiap.produto.entities.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoModelRepository extends JpaRepository<ProdutoModel, Long> {
    @Override
    List<ProdutoModel> findAllById(Iterable<Long> longs);
}