package morozov.controller;


import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;
import morozov.services.techService.GroupTechService;
import morozov.services.techService.ProductTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private GroupTechService groupTechService;

    @Autowired
    private ProductTechService productTechService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/index";
    }


    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductDTO productDTO) {
        productTechService.createProduct(productDTO);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/createGroup", "/editGroup/createGroup"}, method = RequestMethod.POST)
    public String createGroup(@ModelAttribute("group") GroupDTO groupDTO) {
        groupTechService.createGroup(groupDTO);
        return "redirect:/index";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productTechService.deleteProduct(id);
        return "redirect:/index";
    }

    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
        groupTechService.deleteGroup(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String findAllGroups(Model model) {
        model.addAttribute("group", new GroupDTO());
        model.addAttribute("groupList", groupTechService.findAllGroups());
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("productList", productTechService.findAllProducts());
        return "index";
    }

    @RequestMapping("/editGroup/{id}")
    public String editGroup(@PathVariable("id") Long id, Model model) {
        model.addAttribute("group", groupTechService.findGroup(id));
        model.addAttribute("groupList", groupTechService.findAllGroups());
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("productList", productTechService.findAllProducts());
        return "index";
    }
}