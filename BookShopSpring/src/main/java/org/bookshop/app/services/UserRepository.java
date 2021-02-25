package org.bookshop.app.services;

import org.bookshop.web.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements ProjectRepository<User> {

    List<User> userList = new ArrayList<>();

    @Override
    public List<User> retreiveAll() {
        return userList;
    }

    @Override
    public void store(User user) {
        userList.add(user);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (User user : userList) {
            if (user.getId().equals(bookIdToRemove)) {
                userList.remove(user);

                return true;
            }
        }

        return false;
    }
}
