//package kz.iitu.lab5.service.impl;
//
//import kz.iitu.lab5.repository.UsersRepository;
//import kz.iitu.lab5.service.UsersService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class UsersServiceImpl implements UsersService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Override
//    public List<Users> findAll() {
//        return usersRepository.findAll();
//    }
//
//    @Override
//    public Users save(Users user) {
//        if(user.getId() != null){
//            return usersRepository.save(user);
//        }
//        return null;
//    }
//
//    @Override
//    public Users register(Users user) {
//        Users found = usersRepository.findUsersByName(user.getName()).orElse(null);
//        if(found==null){
//            return usersRepository.save(user);
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public Users getById(Long id) {
//        return usersRepository.findUsersById(id).orElse(null);
//    }
//
//    @Override
//    public Users findById(Long id) {
//        return (Users) usersRepository.getById(id);
//    }
//
//    @Override
//    public Users findByName(String name) {
//        return usersRepository.findUsersByName(name).orElse(null);
//    }
//
//    @Override
//    public Users findByPosition(String position) {
//        return usersRepository.findUsersByPosition(position).orElse(null);
//    }
//
//}
