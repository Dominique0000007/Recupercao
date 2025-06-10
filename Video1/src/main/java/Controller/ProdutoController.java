package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Entity.EntidadeProduto.Produto;
import Repository.ProdutoRepository;

	@Controller
		@RequestMapping("/produtos")
public class ProdutoController {
	
		    @Autowired
		    private ProdutoRepository produtoRepository;
		    
		    private String Produto;
		    
		    @GetMapping
		    public String listar(Model model) {
		        model.addAttribute("produtos", produtoRepository.findAll());
		        return "produtos/listar";
		    }
		    
		    @GetMapping("/novo")
		    public String novo(Model model) {
		        return "produtos/formulario";
		    }
		    
		    @PostMapping
		    public String salvar(@Validated Produto produto, BindingResult result) {
		        if (result.hasErrors()) {
		            return "produtos/formulario";
		        }
		        produtoRepository.save(produto);
		        return "redirect:/produtos";
		    }
		    
		    @GetMapping("/editar/{id}")
		    public String editar(@PathVariable Long id, Model model) {
		        model.addAttribute("produto", produtoRepository.findById(id).orElseThrow());
		        return "produtos/formulario";
		    }
		    
		    @GetMapping("/excluir/{id}")
		    public String excluir(@PathVariable Long id) {
		        produtoRepository.deleteById(id);
		        return "redirect:/produtos";
		    }
		}