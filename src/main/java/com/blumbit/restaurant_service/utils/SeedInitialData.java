package com.blumbit.restaurant_service.utils;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.restaurant_service.entity.Cliente;
import com.blumbit.restaurant_service.entity.Menu;
import com.blumbit.restaurant_service.entity.Plato;
import com.blumbit.restaurant_service.repository.ClienteRepository;
import com.blumbit.restaurant_service.repository.MenuRepository;
import com.blumbit.restaurant_service.repository.PlatoRepository;

@Component
public class SeedInitialData implements CommandLineRunner{

    private final ClienteRepository clienteRepository;

    private final MenuRepository menuRepository;

    private final PlatoRepository platoRepository;

    public SeedInitialData(ClienteRepository clienteRepository, MenuRepository menuRepository, PlatoRepository platoRepository) {
        this.clienteRepository = clienteRepository;
        this.menuRepository = menuRepository;
        this.platoRepository = platoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("test");
        cliente.setApellidos("test");
        cliente.setCorreo("test@test.com");
        cliente.setEnable(true);
        cliente.setIdentifier("00001");
        cliente.setNit("123456");
        cliente.setRazonSocial("Test SA");
        cliente.setPassword("$2a$12$Z7KBbRgwdXYx/NG4jc1/FetEk3Xg7lD44Lp5FV/LZl37xHPqWjSdC");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("test2");
        cliente2.setApellidos("test2");
        cliente2.setCorreo("test@test2.com");
        cliente2.setEnable(true);
        cliente2.setIdentifier("00002");
        cliente2.setNit("654321");
        cliente2.setRazonSocial("Test2 SA");
        cliente2.setPassword("$2a$12$Z7KBbRgwdXYx/NG4jc1/FetEk3Xg7lD44Lp5FV/LZl37xHPqWjSdC");

        clienteRepository.saveAll(List.of(cliente, cliente2));

        //SEEDERS MENUS
        Menu menu  = new Menu();
        menu.setNombre("Pollo Frito");
        menu.setActive(true);

        Menu menu2 = new Menu();
        menu2.setNombre("Hamburguesas");
        menu2.setActive(true);

        Menu menu3 = new Menu();
        menu3.setNombre("Postres");
        menu3.setActive(true);

        List<Menu> menusCreated = menuRepository.saveAll(List.of(menu, menu2, menu3));

        //SEEDERS PLATOS
        Plato plato = new Plato();
        plato.setNombre("Pollo Frito Combo Simple");
        plato.setPrecio(new BigDecimal(16.00));
        plato.setImage("pollo.jpg");
        plato.setMenu(menusCreated.get(0));

        Plato plato2 = new Plato();
        plato2.setNombre("Pollo Frito Combo Doble");
        plato2.setPrecio(new BigDecimal(21.00));
        plato2.setImage("pollo.jpg");
        plato2.setMenu(menusCreated.get(0));

        Plato plato3 = new Plato();
        plato3.setNombre("Pollo Frito Combo Trio");
        plato3.setPrecio(new BigDecimal(28.00));
        plato3.setImage("pollo.jpg");
        plato3.setMenu(menusCreated.get(0));

        Plato plato4 = new Plato();
        plato4.setNombre("Hamburguesa Simple");
        plato4.setPrecio(new BigDecimal(16.00));
        plato4.setImage("burguer.jpeg");
        plato4.setMenu(menusCreated.get(1));

        Plato plato5 = new Plato();
        plato5.setNombre("Hamburguesa Doble");
        plato5.setPrecio(new BigDecimal(24.00));
        plato5.setImage("burguer.jpeg");
        plato5.setMenu(menusCreated.get(1));

        Plato plato6 = new Plato();
        plato6.setNombre("Hamburguesa con papas");
        plato6.setPrecio(new BigDecimal(28.00));
        plato6.setImage("burguer.jpeg");
        plato6.setMenu(menusCreated.get(1));

        Plato plato7 = new Plato();
        plato7.setNombre("Dona");
        plato7.setPrecio(new BigDecimal(16.00));
        plato7.setImage("postgres.jpeg");
        plato7.setMenu(menusCreated.get(2));

        Plato plato8 = new Plato();
        plato8.setNombre("Pollo Frito Combo Simple");
        plato8.setPrecio(new BigDecimal(16.00));
        plato8.setImage("postgres.jpeg");
        plato8.setMenu(menusCreated.get(2));

    }

}
