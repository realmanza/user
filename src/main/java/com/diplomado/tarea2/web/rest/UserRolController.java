package com.diplomado.tarea2.web.rest;
import com.diplomado.tarea2.services.UserRolService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("v1/userRoles")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }
    @PatchMapping("/{id}")
    public boolean inActive(@PathVariable final Integer id){
        return userRolService.inActive(id);
    }

}
