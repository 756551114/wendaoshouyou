package com.cool.wendao.manager.business.pet.controller;


import com.alibaba.fastjson.JSONObject;
import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.community.model.Pet;
import com.cool.wendao.community.server.BasePetService;
import com.reger.dubbo.annotation.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("business/pet")
public class PetController {

    @Inject
    private BasePetService basePetService;

    @GetMapping("pet_index")
    public void index(HttpServletRequest request) {
    }

    @GetMapping("pet_add")
    public void petAdd(HttpServletRequest request, Integer id) {
        if (id != null) {
            Pet pet = basePetService.findById(id);
            if (pet != null) {
                request.setAttribute("pet", pet);
            }
        }
    }

    @GetMapping("pet_data")
    @ResponseBody
    public MgtPageBean<Pet> petData(String name, MgtPageBean<Pet> pageBean) {
        pageBean.setWhere(new HashMap<>(1));
        pageBean.getWhere().put("name", name);
        return basePetService.findByPageBean(pageBean);
    }

    @PostMapping("pet_save")
    @ResponseBody
    public ResultBean petAddPost(@RequestBody JSONObject jsonObject) {
        Pet pet = jsonObject.toJavaObject(Pet.class);
        if (pet.getId() == null) {
            return basePetService.petAdd(pet);
        } else {
            basePetService.updateById(pet);
            return ResultBean.SUCCESS();
        }
    }

    @GetMapping("pet_delete")
    @ResponseBody
    public ResultBean petDelete(int id) {
        Pet pet = new Pet();
        pet.setId(id);
        pet.setDeleted(1);
        basePetService.updateById(pet);
        return ResultBean.SUCCESS();
    }

}
