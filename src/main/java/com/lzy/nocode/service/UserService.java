package com.lzy.nocode.service;

import com.lzy.nocode.model.dto.user.UserQueryRequest;
import com.lzy.nocode.model.entity.User;
import com.lzy.nocode.model.vo.LoginUserVO;
import com.lzy.nocode.model.vo.UserVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户 服务层。
 *
 * @author lzy
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);


    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取盐值
     * @param userPassword
     * @return
     */

    public String getEncryptPassword(String userPassword);


    /**
     * 返回可见用户信息
     * @param user
     * @return
     */
    public UserVO getUserVO(User user);

    /**
     * 获取可见用户列表
     * @return
     */
    public List<UserVO> getUserVOList(List<User> userList);


/**
 * 根据用户查询请求参数构建查询条件包装器
 *
 * @param userQueryRequest 用户查询请求参数对象，包含查询条件
 * @return QueryWrapper 返回一个包含查询条件的MyBatis-Plus的QueryWrapper对象，
 *         用于构建数据库查询条件
 */
    public QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);


}
