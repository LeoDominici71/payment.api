package com.fiap.payment.api.infra.utils;

import com.fiap.payment.api.adapters.input.entities.request.CartaoDTO;
import com.fiap.payment.api.adapters.input.entities.request.ClienteDTO;
import com.fiap.payment.api.adapters.input.entities.request.PagamentoDTO;
import com.fiap.payment.api.adapters.input.entities.response.PagamentoListDTO;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.ClienteEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.PagamentoEntity;
import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.entities.Pagamento;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;

public class ClassMapper {

    public static Cliente toCliente(ClienteEntity entity){
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setCpf(entity.getCpf());
        cliente.setNome(entity.getNome());
        cliente.setEmail(entity.getEmail());
        cliente.setCep(entity.getCep());
        cliente.setCidade(entity.getCidade());
        cliente.setEstado(entity.getEstado());
        cliente.setRua(entity.getRua());
        cliente.setTelefone(entity.getTelefone());
        cliente.setPais(entity.getPais());

        return cliente;

    }

    public static Cliente toClienteFromDTO(ClienteDTO entity){
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setCpf(entity.getCpf());
        cliente.setNome(entity.getNome());
        cliente.setEmail(entity.getEmail());
        cliente.setCep(entity.getCep());
        cliente.setCidade(entity.getCidade());
        cliente.setEstado(entity.getEstado());
        cliente.setRua(entity.getRua());
        cliente.setTelefone(entity.getTelefone());
        cliente.setPais(entity.getPais());

        return cliente;

    }

    public static Cartao toCartao(CartaoEntity entity){
        Cartao cartao = new Cartao();
        cartao.setCpf(entity.getCpf());
        cartao.setLimite(entity.getLimite());
        cartao.setNumero(entity.getNumero());
        cartao.setDataValidade(entity.getDataValidade());
        cartao.setCvv(entity.getCvv());

        return cartao;
    }

    public static CartaoEntity limitUpdate(CartaoEntity entity, Double value){
        entity.setLimite( String.valueOf(Double.parseDouble(entity.getLimite()) - value));

        return entity;
    }

    public static Cartao toCartaoFromCartaoDTO(CartaoDTO entity){
        Cartao cartao = new Cartao();
        cartao.setCpf(entity.getCpf());
        cartao.setLimite(entity.getLimite());
        cartao.setNumero(entity.getNumero());
        cartao.setDataValidade(entity.getDataValidade());
        cartao.setCvv(entity.getCvv());

        return cartao;
    }

    public static Pagamento toPagamento(PagamentoEntity pagamentoEntity){
        Pagamento pagamento = new Pagamento();
        pagamento.setCpf(pagamentoEntity.getCpf());
        pagamento.setNumero(pagamentoEntity.getNumero());
        pagamento.setDataValidade(pagamentoEntity.getDataValidade());
        pagamento.setCvv(pagamentoEntity.getCvv());
        pagamento.setValor(pagamentoEntity.getValor());
        pagamento.setChavePagamento(pagamentoEntity.getChavePagamento());
        pagamento.setClientId(pagamentoEntity.getClientId());

        return pagamento;
    }

    public static Pagamento toPagamentoFromDTO(PagamentoDTO pagamentoDTO){
        Pagamento pagamento = new Pagamento();
        pagamento.setCpf(pagamentoDTO.getCpf());
        pagamento.setNumero(pagamentoDTO.getNumero());
        pagamento.setDataValidade(pagamentoDTO.getDataValidade());
        pagamento.setCvv(pagamentoDTO.getCvv());
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setChavePagamento(pagamentoDTO.getChavePagamento());

        return pagamento;
    }

    public static PagamentoListDTO toPagamentoList(Pagamento pagamento){
        PagamentoListDTO pagamentoDTO = new PagamentoListDTO();
        pagamentoDTO.setMetodoPagamento("Cartao de credito");
        pagamentoDTO.setDescricao("Pagamento efetuado do produto de chave " + pagamento.getChavePagamento());
        pagamentoDTO.setStatus("Aprovado");
        pagamentoDTO.setValor(pagamento.getValor());

        return pagamentoDTO;
    }


}
