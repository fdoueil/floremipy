package edd.floremipy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edd.floremipy.dto.CatalogueLineDTO;
import edd.floremipy.service.CatalogueServiceInterface;

@RestController
@RequestMapping(value="/api")
public class CatalogueViewController {
	
	@Autowired
	CatalogueServiceInterface catalogueService;

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<CatalogueLineDTO> allProducts(){
        return catalogueService.listCatalogueLinesJson();
    }

}
