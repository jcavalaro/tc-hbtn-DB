package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(519.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
       produtoModel.create(p1);

        //1B) findbyIdProduto
        //Produto produtoUpdate = produtoModel.findByIdProduto(1L);

        // 1C) updateProduto
        //produtoUpdate.setPreco(990.0);
        //produtoModel.update(produtoUpdate);

        //1D)Remove
       // Produto produtoUpdateDelete = produtoModel.findByIdProduto(1L);
       // produtoModel.delete(produtoUpdateDelete);


        //2) Buscando todos os produtos na base de dados
       List<Produto> produtos = produtoModel.findAll();
       System.out.println("Qtde de produtos encontrados : " + produtos.size());
//-----------------------------
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pe1 = new Pessoa();
        pe1.setNome("Jurema");
        pe1.setEmail("juremona.oila@teste.com");
        pe1.setIdade(27);
        pe1.setCpf("349.009.343-98");
        pe1.setDataDeNascimento("09/08/1994");


        // 1) Criando um produto
        pessoaModel.create(pe1);

        //1B) findbyIdPessoa
        //Pessoa pessoaUpdate = pessoaModel.findByIdPessoa(1L);

        // 1C) updatePessoa
        //pessoaUpdate.setNome("josefa");
        //pessoaModel.update(pessoaUpdate);

        //1D)Remove
        // Pessoa pessoaUpdateDelete = pessoaModel.findByIdPessoa(1L);
        // pessoaModel.delete(pessoaUpdateDelete);


        //2) Buscando todos os produtos na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de Pessoas encontradas : " + pessoas.size());

    }

}
