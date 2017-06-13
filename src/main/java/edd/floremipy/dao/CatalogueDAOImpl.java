package edd.floremipy.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.CatalogueLineDTO;

@Repository("catalogueDAO")
@Scope("singleton")
public class CatalogueDAOImpl implements CatalogueDAOInterface {
/* (non-Javadoc)
 * @see edd.floremipy.dao.CatalogueDAOInterface#findCatalogue()
 */
@Override
public List<CatalogueLineDTO> findCatalogue () {
	return Collections.emptyList();
	}

@Override
public void setCatalogue(CatalogueLineDTO catalogueLineDTO) {
	
}
}
