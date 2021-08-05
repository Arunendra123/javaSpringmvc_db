package userservice;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import userdao.UserDAO;
import userentity.UserA;

public class UserService implements UserDAO{

	private HibernateTemplate hibernateTemplate;
	
    @Transactional
    @Override
	public void insert(UserA user) {
		hibernateTemplate.save(user);
	}

    @Transactional
	@Override
	public void update(UserA user) {
		hibernateTemplate.update(user);
	}

    @Transactional
	@Override
	public void delete(String userId) {
		hibernateTemplate.delete(hibernateTemplate.get(UserA.class,userId));
	}
	
	@Override
	public List<UserA> list() {
		return hibernateTemplate.loadAll(UserA.class);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
