package morozov.controller;


import morozov.dto.GroupDTO;
import morozov.entity.Group;
import morozov.services.business.GroupBusinessService;
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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {

        return "redirect:/index";
    }






    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public String createGroup(@ModelAttribute("group") GroupDTO groupDTO) {
        this.groupBusinessService.createGroup(new Group(groupDTO.getId(), groupDTO.getGroupName()));

        return "redirect:/index";
    }


    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
        this.groupBusinessService.deleteGroup(id);

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
        model.addAttribute("group", new GroupDTO());
        model.addAttribute("groupList", groupDTOS);

        return "index";
    }




}