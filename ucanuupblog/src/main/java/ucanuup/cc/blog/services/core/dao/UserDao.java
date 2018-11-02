package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ucanuup.cc.blog.services.core.entity.User;


public interface UserDao extends CrudRepository<User, String>,JpaSpecificationExecutor<User> {

		/**
		 * @Method: com.bozhon.service.base.datamanager.UserJPA.findUserByEmail
		 * @Description:  通过用户账号查询用户信息
		 * @author: WenBin
		 * @date: 2017年10月27日
		 * @version: 1.0
		 * @param userAccount 用户账号
		 * @return
		 * User
		 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
		 */
		@Query("select u from User u where u.userAccount = :userAccount")
		User findUserByEmail(@Param("userAccount") String userAccount);

		/**
		 * @Title:  UserDao.java   
		 * @Package ucanuup.cc.api.user.dao   
		 * @Description:   查询登录信息
		 * @author: WenBin     
		 * @date:   2018年10月19日 上午9:55:55   
		 * @version V1.0 
		 * @Copyright: 2018
		 */
		@Query("select u from User u where (u.userAccount = :userAccount  or u.email = :email or u.phone = :phone ) and u.userPassword = :password and u.deleted = 0")
		User findUserByEmailOrAccountOrPhoneWithPassword(
				@Param("userAccount") String account,
				@Param("email") String email,
				@Param("phone") String phone,
				@Param("password") String password);
		
		/**
		 * @Method: com.bozhon.service.base.datamanager.UserJPA.queryUsersAndSortIt
		 * @Description: 查询用户分页信息
		 * @author: WenBin
		 * @date: 2017年10月27日
		 * @version: 1.0
		 * @param pageable
		 * @return
		 * Page<User>
		 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
		 */
		@Query(value="SELECT T FROM User T ",countQuery="SELECT COUNT(1) FROM User T")
		Page<User> queryUsersAndSortIt(Pageable pageable);
}
