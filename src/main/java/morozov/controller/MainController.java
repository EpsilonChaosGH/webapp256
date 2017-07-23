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

    @RequestMapping(value = {"/saveProduct", "/editProduct/saveProduct"}, method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO) {
        productTechService.saveProductWithMassage(productDTO);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/saveGroup", "/editGroup/saveGroup"}, method = RequestMethod.POST)
    public String saveGroup(@ModelAttribute("group") GroupDTO groupDTO) {
        groupTechService.saveGroupWithMessage(groupDTO);
        return "redirect:/index";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productTechService.deleteProductWithMessage(id);
        return "redirect:/index";
    }

    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
        groupTechService.deleteGroupWithMessage(id);
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

    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("group", new GroupDTO());
        model.addAttribute("groupList", groupTechService.findAllGroups());
        model.addAttribute("product", productTechService.findProduct(id));
        model.addAttribute("productList", productTechService.findAllProducts());
        return "index";
    }
}