package br.com.santander.ecommerce.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class PedidoDtoInput {
	
	@NotNull
	private Integer clienteId;
	private List<ItemPedidoInputDto> itensPedidoInputDto = new ArrayList<>();

	public Integer getClienteId() {
		return clienteId;
	}

	public List<ItemPedidoInputDto> getItensPedidoInputDto() {
		return itensPedidoInputDto;
	}
}
