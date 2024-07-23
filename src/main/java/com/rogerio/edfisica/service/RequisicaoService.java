package com.rogerio.edfisica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.repositories.RequisicaoMaterialRepository;
import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;

@Service
public class RequisicaoService {
	
	
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private RequisicaoMaterialRepository requisicaoMaterialRepository;
	
	public RequisicaoMaterial findById(Long id) {
		Optional<RequisicaoMaterial> obj = requisicaoMaterialRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException
				("Objeto não encontrado! Id: " + id + ", Tipo: " + RequisicaoMaterial.class.getName()));
	}

	public List<RequisicaoMaterial> findAll() {
		return requisicaoMaterialRepository.findAll();
		
		
	}
	public RequisicaoMaterial create(RequisicaoMaterial obj) {
        // Recupera o material pelo ID presente na requisição
        Material material = materialService.findById(obj.getMaterial().getId());

        // Verifica se há material disponível em estoque
        if (material.getQuantidade() >= obj.getQuantidade()) {
            // Atualiza a quantidade do material em estoque
            int novaQuantidade = material.getQuantidade() - obj.getQuantidade();
            material.setQuantidade(novaQuantidade);

            // Salva a alteração no estoque do material
            materialService.update(material.getId(), material);

            // Salva a requisição
            return requisicaoMaterialRepository.save(obj);
        } else {
            // Lança uma exceção ou trata a situação de estoque insuficiente
            // Aqui você pode lançar uma exceção ou tomar alguma ação adequada
            // dependendo da sua lógica de negócio
            throw new RuntimeException("Estoque insuficiente para atender a requisição");
        }
    }

	//public RequisicaoMaterial create(RequisicaoMaterial obj) {
	
		//return requisicaoMaterialRepository.save(obj);
	//}

	public RequisicaoMaterial update(Long id, RequisicaoMaterial obj) {
		RequisicaoMaterial ob = findById(id);
		
		  Material materialAntigo = materialService.findById(ob.getMaterial().getId());
		    Material materialNovo = materialService.findById(obj.getMaterial().getId());

		    int quantidadeAntiga = ob.getQuantidade();
		    int quantidadeNova = obj.getQuantidade();

		    int diferencaQuantidade = quantidadeNova - quantidadeAntiga;

		    // Se a quantidade for aumentada na requisição
		    if (diferencaQuantidade > 0) {
		        // Verifica se há material disponível em estoque para o aumento
		        if (materialNovo.getQuantidade() >= diferencaQuantidade) {
		            int novaQuantidade = materialNovo.getQuantidade() - diferencaQuantidade;
		            materialNovo.setQuantidade(novaQuantidade);

		            // Atualiza o estoque do material novo após o aumento na requisição
		            materialService.update(materialNovo.getId(), materialNovo);

		            // Atualiza a quantidade na requisição
		            ob.setQuantidade(obj.getQuantidade());

		            // Salva a requisição atualizada
		            return requisicaoMaterialRepository.save(ob);
		        } else {
		            throw new RuntimeException("Estoque insuficiente para atender ao aumento da requisição");
		        }
		    }
		    // Se a quantidade for diminuída na requisição
		    else if (diferencaQuantidade < 0) {
		        int novaQuantidade = materialAntigo.getQuantidade() - diferencaQuantidade;
		        materialAntigo.setQuantidade(novaQuantidade);

		        // Atualiza o estoque do material antigo após a diminuição na requisição
		        materialService.update(materialAntigo.getId(), materialAntigo);

		        // Atualiza a quantidade na requisição
		        ob.setQuantidade(obj.getQuantidade());

		        // Salva a requisição atualizada
		        return requisicaoMaterialRepository.save(ob);
		    } else {
		        // Se a quantidade na requisição não mudou
		        ob.setQuantidade(obj.getQuantidade());

		        // Salva a requisição atualizada
		        return requisicaoMaterialRepository.save(ob);
		    }
		    
		    
		   
		
		
	}
	public void delete(Long id) {
	    RequisicaoMaterial requisicao = findById(id); // Encontra a requisição pelo ID
	    
	    if (requisicao != null) {
	        int quantidadeDeletada = requisicao.getQuantidade(); // Obtém a quantidade deletada
	        
	        requisicaoMaterialRepository.deleteById(id); // Deleta a requisição
	        
	        // Obtém o material relacionado à requisição
	        Material material = requisicao.getMaterial();
	        
	        if (material != null) {
	            // Atualiza o estoque do material adicionando a quantidade deletada
	         atualizarEstoque(id, material, quantidadeDeletada);
	        }
	    }
	}

	private void atualizarEstoque(Long id, Material material, int quantidadeDeletada) {
	    // Verifica se o material e a quantidade a ser removida são válidos
	    if (material != null && quantidadeDeletada > 0) {
	        // Subtrai a quantidade deletada do estoque do material
	        int estoqueAtual = material.getQuantidade();
	        int novoEstoque = estoqueAtual + quantidadeDeletada;
	        
	        // Verifica se o estoque não fica negativo
	        if (novoEstoque >= 0) {
	            material.setQuantidade(novoEstoque);
	            
	            
				// Salva o material no repositório ou executa a lógica necessária para atualizar o estoque
	           // materialService.cadastrar(material);
	            // ou
	             materialService.update(material.getId(), material);
	        } else {
	            // Lógica para lidar com estoque negativo, se necessário
	        }
	    }
	}

	
	
	
	

}
