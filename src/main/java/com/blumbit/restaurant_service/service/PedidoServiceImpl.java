package com.blumbit.restaurant_service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.restaurant_service.dto.request.DetallePedidoRequestDto;
import com.blumbit.restaurant_service.dto.request.PedidoRequestDto;
import com.blumbit.restaurant_service.dto.response.PedidoResponseDto;
import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.entity.DetallePedido;
import com.blumbit.restaurant_service.entity.Pedido;
import com.blumbit.restaurant_service.repository.ClienteRepository;
import com.blumbit.restaurant_service.repository.DetallePedidoRepository;
import com.blumbit.restaurant_service.repository.PedidoRepository;
import com.blumbit.restaurant_service.repository.PlatoRepository;

@Service
public class PedidoServiceImpl implements IPedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    private final PedidoRepository pedidoRepository;

    private final ClienteRepository clienteRepository;

    private final PlatoRepository platoRepository;

    public PedidoServiceImpl(DetallePedidoRepository detallePedidoRepository, PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository, PlatoRepository platoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.platoRepository = platoRepository;
    }

    @Override
    public String createPedido(PedidoRequestDto pedidoRequestDto) {

        Cliente clienteRetrieved = clienteRepository.findById(pedidoRequestDto.getClienteId()).get();
        if (clienteRetrieved == null) {
            // TODO create message resource to clientes
            try {
                throw new Exception("Cliente no encontrado");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Pedido pedidoToCreate = new Pedido();
        pedidoToCreate.setFecha(LocalDateTime.now());
        pedidoToCreate.setCliente(clienteRetrieved);
        pedidoToCreate.setTotal(calculateTotal(pedidoRequestDto.getDetallesPedido()));
        pedidoToCreate = pedidoRepository.save(pedidoToCreate);
        for (DetallePedidoRequestDto detallePedidoRequestDto : pedidoRequestDto.getDetallesPedido()) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setCantidad(detallePedidoRequestDto.getCantidad());
            detallePedido.setPedido(pedidoToCreate);
            detallePedido.setPlato(platoRepository.findById(detallePedidoRequestDto.getPlatoId()).get());
            detallePedido.setSubTotal(detallePedidoRequestDto.getSubTotal());
            detallePedidoRepository.save(detallePedido);
        }

        return "Pedido creato exitosamente";
    }

    private Short calculateTotal(List<DetallePedidoRequestDto> detallePedidoRequestDtos) {
        Short total = 0;
        for (DetallePedidoRequestDto detallePedidoRequestDto : detallePedidoRequestDtos) {
            total = (short) (total + detallePedidoRequestDto.getSubTotal());
        }
        return total;
    }

    @Override
    public List<PedidoResponseDto> pedidos() {
        List<PedidoResponseDto> pedidosResponse = new ArrayList<>();
        List<Pedido> pedidos = pedidoRepository.findAll();
        for (Pedido pedido : pedidos) {
            PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();
            pedidoResponseDto.setId(pedido.getId());
            pedidoResponseDto.setFecha(pedido.getFecha());
            pedidoResponseDto.setTotal(pedido.getTotal());
            // TODO ADD DATA DO CLIENTE AND DETALLE PEDIDO
            pedidoResponseDto.setClienteResponseDto(null);
            pedidoResponseDto.setDetallesPedido(null);
            pedidosResponse.add(pedidoResponseDto);
        }
        return pedidosResponse;
    }

}
