package userdao;

import java.util.List;

import userentity.UserA;

public interface UserDAO {
     public void insert(UserA user);
     public void update(UserA user);
     public void delete(String userId);
     public List<UserA> list();
}
