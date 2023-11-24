package com.diplomado.tarea2.web.rest;
import com.diplomado.tarea2.domain.entities.Rol;
import com.diplomado.tarea2.domain.entities.User;
import com.diplomado.tarea2.dto.RolDTO;
import com.diplomado.tarea2.dto.UserViewDTO;
import com.diplomado.tarea2.services.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles(){

        return ResponseEntity.ok().body(rolService.listRoles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return ResponseEntity
                .ok()
                .body(rolService.getRolById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
    @PostMapping
    public ResponseEntity<RolDTO> create(@Valid @RequestBody final RolDTO rol) throws URISyntaxException {
        /*if(rol.getId()!=null){
            throw new IllegalArgumentException("El nuevo rol no puede tener un id.");
        }*/
        RolDTO rolDB=rolService.save(rol);
        return ResponseEntity.created(new URI("v1/roles"+rolDB.getId())).body(rolDB);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{rolId}/users")
    public ResponseEntity<List<UserViewDTO>> listUsersByRolId(@PathVariable final Integer rolId) {
        return ResponseEntity.ok().body(rolService.listUsersByRolId(rolId));
    }
}
