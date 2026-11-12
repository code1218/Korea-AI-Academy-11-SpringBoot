package com.korai.study03.domain.customer.controller;

import com.korai.study03.domain.customer.dto.CustomerCreateRequest;
import com.korai.study03.domain.customer.dto.CustomerResponse;
import com.korai.study03.domain.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")   // URL 패턴: /api/entity(복수형)
public class CustomerController {
    // 컨트롤러 이름 규칙
    // Entity명 + Controller
    // UserController, OrderController, OrderItemController

    // 메서드 이름 규칙
    // CRUD(Create, Read, Update, Delete)
    // C -> POST: 생성
    // createCustomer(), addCustomer(), registerCustomer()
    // R -> GET: 조회
    // 단건 조회: getCustomer(), findCustomer()
    // 다건 조회: getCustomers(), listCustomers(), getCustomerList()
    // U -> PUT, PATCH: 수정
    // updateCustomer(). modifyCustomer()
    // D -> Delete: 삭제
    // deleteCustomer(), removeCustomer()

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerCreateRequest request) {
        System.out.println(request);
        CustomerResponse customerResponse = customerService.create(request);
        return customerResponse;
    }

}















