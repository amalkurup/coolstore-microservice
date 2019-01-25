package com.redhat.coolstore.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redhat.coolstore.model.kie.Product;

@FeignClient(name = "catalogService", url = "localhost")
interface CatalogService {
	@RequestMapping(method = RequestMethod.GET, value = "/api/products")
    List<Product> products();
}