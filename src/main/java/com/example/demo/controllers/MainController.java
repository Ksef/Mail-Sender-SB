package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@AllArgsConstructor
public class MainController {


    private UserDAO userDAO;


    @GetMapping("/users")
    public List<User> users() {
        List<User> users = userDAO.findAll();
//        ArrayList<User> arrayList = new ArrayList<>(users);
//        arrayList.add()
//        arrayList.get()
//        arrayList.remove()
//        arrayList.set(12, new User());
//        arrayList.contains(new User());
//        arrayList.containsAll(collection);

//        LinkedList<User> linkedList = new LinkedList<>(users);
//        linkedList.add()
//        linkedList.get()
//        linkedList.remove()
//        linkedList.set()
//        linkedList.contains()
//        linkedList.containsAll(collection);

//        linkedList.addFirst(new User());
//        linkedList.addLast(new User());
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        linkedList.removeFirstOccurrence(new User());

        /*----set----*/

        System.out.println(users);

//        Set<User> userSet = new HashSet<>(users);
//        System.out.println(userSet);
//        for (User user : userSet) {
//            System.out.println(user.hashCode());
//        }

//        HashSet<User> hashSet = new HashSet<>();
//        hashSet.add(new User(2, "kokos"));
////        hashSet.add(new User(2, "kokos"));
//        hashSet.add(new User(1, "ananas"));
////        hashSet.add(new User(1, "ananas"));
//        hashSet.add(new User(3, "banan"));
//        hashSet.add(new User(5, "tomat"));
//        hashSet.add(new User(4, "potatos"));
////        hashSet.add(new User(4, "potatos"));
//        hashSet.add(new User(6, "mango"));
//        System.out.println(hashSet);
//        Iterator<User> iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            User next = iterator.next();
//            if (next.getId() % 2 == 0) {
//                iterator.remove();
//            }
//
//        }
//        System.out.println(hashSet);


//        Set<User> linkedHashSet = new LinkedHashSet<>();
//        linkedHashSet.add(new User(2, "kokos"));
//        linkedHashSet.add(new User(2, "kokos"));
//        linkedHashSet.add(new User(1, "ananas"));
//        linkedHashSet.add(new User(1, "ananas"));
//        linkedHashSet.add(new User(3, "banan"));
//        linkedHashSet.add(new User(5, "tomat"));
//        linkedHashSet.add(new User(4, "potatos"));
//        linkedHashSet.add(new User(4, "potatos"));
//        linkedHashSet.add(new User(6, "mango"));
//


//        TreeSet<User> treeSet = new TreeSet<>();
//        treeSet.add(new User(2, "kokos"));
//        treeSet.add(new User(1, "ananas"));
//        treeSet.add(new User(3, "banan"));
//        treeSet.add(new User(5, "tomat"));
//        treeSet.add(new User(4, "potatos"));
//        treeSet.add(new User(6, "mango"));
//        System.out.println(treeSet);

        return users;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        userDAO.save(user);
        return user;


    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userDAO.findById(id).get();
    }

    @PatchMapping("/users")
    public User updateUser(@RequestBody User userFromrequest) {
        User userFromDb = userDAO.getById(userFromrequest.getId());
        userDAO.save(userFromrequest);
        return userFromrequest;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDAO.deleteById(id);

    }

}

