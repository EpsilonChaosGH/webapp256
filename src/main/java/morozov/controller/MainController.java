package morozov.controller;


import morozov.dto.GroupDTO;
import morozov.dto.ProductDTO;
import morozov.entity.Group;
import morozov.entity.Product;
import morozov.services.business.GroupBusinessService;
import morozov.services.business.ProductBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private GroupBusinessService groupBusinessService;

    @Autowired
    private ProductBusinessService productBusinessService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductDTO productDTO) {
         Group group = new Group();
         group.setGroupName("Test");
        productBusinessService.createProduct(new Product(productDTO.getId(), productDTO.getProductName(), group));
                //new Group(productDTO.getGroup().getId(), productDTO.getGroup().getGroupName())));

        return "redirect:/index";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productBusinessService.deleteProduct(id);

        return "redirect:/index";
    }

       @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public String createGroup(@ModelAttribute("group") GroupDTO groupDTO) {
        groupBusinessService.createGroup(new Group(groupDTO.getId(), groupDTO.getGroupName()));

        return "redirect:/index";
    }


    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
        groupBusinessService.deleteGroup(id);

        return "redirect:/index";
    }



    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String findAllGroups(Model model) {
        List<Group> groups = groupBusinessService.findAllGroups();
        List<GroupDTO> groupDTOS = new ArrayList<GroupDTO>();
        for (Group group : groups) {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setId(group.getId());
            groupDTO.setGroupName(group.getGroupName());
            groupDTOS.add(groupDTO);
        }
        List<Product> products = productBusinessService.findAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());

//            List<Group> productGroups  = groupBusinessService.findAllGroups();
//            List<GroupDTO> productGroupsDTOS = new ArrayList<GroupDTO>();
//            for (Group productGroup : productGroups) {
//                GroupDTO productGroupsDTO = new GroupDTO();
//                productGroupsDTO.setId(productGroup.getId());
//                productGroupsDTO.setGroupName(productGroup.getGroupName());
//                productDTO.setGroup(productGroupsDTO);
//            }
            productDTOS.add(productDTO);
        }

        model.addAttribute("group", new GroupDTO());
        model.addAttribute("groupList", groupDTOS);

        model.addAttribute("product", new ProductDTO());
        model.addAttribute("productList", productDTOS);

        return "index";
    }
}