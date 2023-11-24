package com.diplomado.tarea2.services.implement;
import com.diplomado.tarea2.domain.entities.User;
import com.diplomado.tarea2.domain.entities.Rol;
import com.diplomado.tarea2.domain.entities.UserDetail;
import com.diplomado.tarea2.domain.entities.UserRol;
import com.diplomado.tarea2.dto.UserDTO;
import com.diplomado.tarea2.dto.UserViewDTO;
import com.diplomado.tarea2.repositories.RolRepository;
import com.diplomado.tarea2.repositories.UserDetailRepository;
import com.diplomado.tarea2.repositories.UserRepository;
import com.diplomado.tarea2.repositories.UserRolRepository;
import com.diplomado.tarea2.services.UserService;
import com.diplomado.tarea2.services.RolService;
import com.diplomado.tarea2.services.mapper.UserMapper;
import com.diplomado.tarea2.services.mapper.UserViewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final UserMapper userMapper;
    private final UserViewMapper userViewMapper;
    private final UserRolRepository userRolRepository;
    private final RolRepository rolRepository;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository, UserMapper userMapper, UserViewMapper userViewMapper, UserRolRepository userRolRepository, RolRepository rolRepository, RolService rolService, RolRepository rolRepository1) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.userMapper = userMapper;
        this.userViewMapper = userViewMapper;
        this.userRolRepository = userRolRepository;
        this.rolRepository = rolRepository1;
    }

    @Override
    public List<UserViewDTO> listUsers() {

        return userRepository.findAll()
                .stream()
                .map(userViewMapper::toDto).collect(Collectors.toList());
    }
    public List<UserViewDTO> listUsersDetailed() {

        return userRepository.findAll()
                .stream()
                .map(userViewMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        User user=userRepository.save(userMapper.toEntity(userDTO));
        if (userDTO.getFirstName()!=null){
            UserDetail userDetail=new UserDetail(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAge(), userDTO.getBirthDay(),user);
            userDetailRepository.save(userDetail);
        }
        if(userDTO.getRoles()!=null) {
            Set<UserRol> userRoles= new HashSet<>();
            for (Integer idUserRol: userDTO.getRoles()) {
                if(rolRepository.existsById(idUserRol)){

                    userRoles.add(new UserRol(true, user,rolRepository.findById(idUserRol).get()));
                }
            }
            userRolRepository.saveAll(userRoles);
        }
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
