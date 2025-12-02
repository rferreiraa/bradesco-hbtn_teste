package src.application;

import src.domain.Cliente;
import src.domain.Pedido;
import src.domain.Produto;
import src.infrastructure.PedidoRepository;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidoRepository.salvar(pedido);
        return pedido;
    }

    public void adicionarProduto(String pedidoId, Produto produto) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) throw new RuntimeException("Pedido não encontrado");
        pedido.adicionarProduto(produto);
        pedidoRepository.salvar(pedido);
    }

    public void pagarPedido(String pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) throw new RuntimeException("Pedido não encontrado");
        pedido.pagar();
        pedidoRepository.salvar(pedido);
    }

    public void cancelarPedido(String pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) throw new RuntimeException("Pedido não encontrado");
        pedido.cancelar();
        pedidoRepository.salvar(pedido);
    }
}
